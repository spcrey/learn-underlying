package comparingDesignPattern

object CommandPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val context = Context()
        context.execute()
        context.bindCommand(CommandA())
        context.execute()
        context.bindCommand(CommandB())
        context.bindCommand {
            println("CommandC.execute()")
        }
        context.execute()
        context.unbindCommand()
        context.execute()
    }
    fun interface Command {
        fun execute()
    }
    class CommandA : Command {
        override fun execute() {
            println("CommandA.execute()")
        }
    }
    class CommandB : Command {
        override fun execute() {
            println("CommandB.execute()")
        }
    }
    class Context {
        private var command: Command? = null
        fun bindCommand(command: Command) {
            this.command = command
        }
        fun unbindCommand() {
            this.command = null
        }
        fun execute() {
            command?.execute()
        }
    }
}