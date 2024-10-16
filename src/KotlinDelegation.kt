import dataStructure.BiTree
import kotlin.properties.Delegates

object KotlinDelegation {

    interface Base {
        val message: String
        fun print()
        fun println()
        fun printMessage()
    }

    class BaseImpl(private val x: Int) : Base {
        override val message = "BaseImpl: x = $x"

        override fun print() {
            print(x)
        }
        override fun println() {
            println(x)
        }

        override fun printMessage() {
            print(message)
        }
    }

    class Derived(base: Base) : Base by base {
        override val message = "Message of Derived"
        override fun print() {
            print(0)
        }
    }

    private var observableValue by Delegates.observable("inti observable value") { _, old, new ->
        println("$old -> $new")
    }

    private val lazyValue: String by lazy {
        println("init lazy value")
        "lazy value"
    }


    @JvmStatic
    fun main(args: Array<String>) {
        println(lazyValue)
        println(lazyValue)
        observableValue = "first"
        observableValue = "second"
    }
}
typealias NodeSet = Set<String>
