package comparingDesignPattern

object StrategyPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val context = Context()
        context.strategy = StrategyA()
        context.execute(1,2)
        context.strategy = StrategyB()
        context.execute(1,2)
        context.strategy = StrategyC()
        context.execute(1,2)
        context.strategy = object : Strategy() {
            override fun execute(a: Int, b: Int): Int {
                println("StrategyD.execute()")
                return a / b
            }
        }
        context.execute(1,2)
        val higherOrderFunContext = HigherOrderFunContext()
        higherOrderFunContext.execute(1,2)
        higherOrderFunContext.strategy = fun(a: Int, b: Int) : Int {
            println("HigherOrderFun.execute()")
            return a + b
        }
        higherOrderFunContext.execute(1,2)
    }
    abstract class Strategy {
        abstract fun execute(a: Int, b: Int): Int
    }
    class StrategyA : Strategy() {
        override fun execute(a: Int, b: Int): Int {
            println("StrategyA.execute()")
            return a + b
        }
    }
    class StrategyB : Strategy() {
        override fun execute(a: Int, b: Int): Int {
            println("StrategyB.execute()")
            return a - b
        }
    }
    class StrategyC : Strategy() {
        override fun execute(a: Int, b: Int): Int {
            println("StrategyC.execute()")
            return a * b
        }
    }
    class Context{
        var strategy: Strategy? = null
        fun execute(a: Int, b: Int) {
            strategy?.let {
                println(it.execute(a, b))
            }
        }
    }
    class HigherOrderFunContext {
        var strategy: ((Int, Int) -> Int)? = null
        fun execute(a: Int, b: Int) {
            strategy?.let {
                println(it(a, b))
            }
        }
    }
}