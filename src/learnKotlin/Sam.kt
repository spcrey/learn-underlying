package learnKotlin

object Sam {
    interface InterfaceEvent {
        fun run()
    }

    fun interface FunEvent {
        fun run()
    }

    class Executor {
        fun execute(event: InterfaceEvent){
            event.run()
        }

        fun execute(event: FunEvent){
            event.run()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val executor = Executor()
        val interfaceEvent = object : InterfaceEvent {
            override fun run() {
                println("InterfaceEvent: run")
            }
        }
        executor.execute(interfaceEvent)
        val funEvent = FunEvent {
            println("FunEvent: run")
        }
        executor.execute(funEvent)
        executor.execute{
            println("FunEvent: run")
        }
    }
}