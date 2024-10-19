package comparingDesignPattern

object IteratorPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val container: Container<Int> = ConcreteContainer()
        intArrayOf(1,2,3,4,5).forEach { container.add(it) }
        val iterator: Iterator<Int> = container.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }
    interface Iterator<T> {
        fun next(): T
        fun hasNext(): Boolean
    }
    interface Container<T> {
        fun add(element: T)
        val size
            get() = 0
        fun getItem(index: Int): T
        fun iterator(): Iterator<T>
    }
    class ConcreteContainer<T> : Container<T> {
        val list = mutableListOf<T>()
        override val size: Int
            get() = list.size
        override fun add(element: T) {
            list.add(element)
        }
        override fun getItem(index: Int): T {
            return list[index]
        }
        override fun iterator(): Iterator<T> {
            return ConcreteIterator<T>(this)
        }
    }
    class ConcreteIterator<T>(private val container: Container<T>): Iterator<T> {
        private var index = 0
        override fun next(): T {
            return container.getItem(index++)
        }
        override fun hasNext(): Boolean {
            return index < container.size
        }
    }
}