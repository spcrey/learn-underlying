package comparingDesignPattern

object CompositePatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val c1 = Leaf("c1")
        val c2 = Leaf("c2")
        val c3 = Composite("c3")
        c3.addChild(c1)
        c3.addChild(c2)
        val c4 = Leaf("c4")
        val c5 = Composite("c5")
        c5.addChild(c3)
        c5.addChild(c4)
        c5.method()
    }
    interface Component {
        fun method()
    }
    class Composite(val name: String) : Component {
        private val children = mutableListOf<Component>()
        override fun method() {
            println("Composite(name=$name).method()")
            children.forEach { it.method() }
        }
        fun addChild(child: Component) {
            children.add(child)
        }
    }
    class Leaf(val name: String) : Component {
        override fun method() {
            println("Leaf(name=$name).method()")
        }
    }
}