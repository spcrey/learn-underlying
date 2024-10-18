package comparingDesignPattern

object ResponsibilityChainPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val handlerA = HandlerA()
        val handlerB = HandlerB()
        val handlerC = HandlerC()
        handlerA.next = handlerB
        handlerB.next = handlerC
        handlerA.handleRequest(1)
        handlerA.handleRequest(10)
        handlerA.handleRequest(100)
        handlerA.handleRequest(1000)
    }
    abstract class Handler {
        var next: Handler? = null
        abstract fun handleRequest(num: Int)
    }
    class HandlerA : Handler() {
        override fun handleRequest(num: Int) {
            if (num < 10) {
                println("HandlerA.handleRequest()")
            } else {
                next?.handleRequest(num)
            }
        }
    }
    class HandlerB : Handler() {
        override fun handleRequest(num: Int) {
            if (num < 100) {
                println("HandlerB.handleRequest()")
            } else {
                next?.handleRequest(num)
            }
        }
    }
    class HandlerC : Handler() {
        override fun handleRequest(num: Int) {
            if (num < 1000) {
                println("HandlerC.handleRequest()")
            } else {
                next?.handleRequest(num)
            }
        }
    }
}