package comparingDesignPattern

object PrototypePatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val list = mutableListOf("A", "B", "C", "D")
        val cloneable = ConcreteCloneable(1, list)
        val cloner = cloneable.clone()
        cloneable.num = 2
        cloneable.list[3] = "E"
        println(cloneable.toString())
        println(cloner.toString())
    }

    interface Cloneable {
        fun clone(): Cloneable
    }

    data class ConcreteCloneable(var num: Int, val list: MutableList<String>) : Cloneable {
        override fun clone(): ConcreteCloneable {
            return ConcreteCloneable(num, list.toMutableList()) as ConcreteCloneable
        }
    }

}