package comparingDesignPattern

import designPattern.AdapterPattern

object AdapterPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val adaptee = Adaptee()
        val adapter = Adapter(adaptee)
        println(adapter.transform())
    }
    interface Transformer {
        fun transform() : String
    }
    class Adaptee {
        fun method(): String {
            return "Adaptee.method()"
        }
    }
    class Adapter(private val adaptee: Adaptee) : Transformer {
        private fun handleContent(content: String): String {
            println("Adapter.handleContent()")
            return "Transformed: $content"
        }
        override fun transform(): String {
            return handleContent(adaptee.method());
        }
    }
}