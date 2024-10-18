package comparingDesignPattern

object StatePatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val context = Context()
        context.state = StateA()
        context.action()
        context.state = StateB()
        context.action()
        context.state = StateC()
        context.action()
        context.state = object : State {
            override fun action() {
                println("StateD.action()")
            }
        }
        context.action()
        context.state = State {
            println("StateE.action()")
        }
        context.action()
    }
    fun interface State {
        fun action()
    }
    class StateA : State {
        override fun action() {
            println("StateA.action()")
        }
    }
    class StateB : State {
        override fun action() {
            println("StateB.action()")
        }
    }
    class StateC : State {
        override fun action() {
            println("StateC.action()")
        }
    }
    class Context(var state: State = StateA()) {
        fun action() {
            state.action()
        }
    }
}