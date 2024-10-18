package learnKotlin

object HigherOrderFunction {
    @JvmStatic
    fun main(args: Array<String>) {
        execute(
            fun(content: String) {
                println("1:$content")
            }
        )
        execute { content -> println("2:$content") }
        val function = { content: String -> println("3:$content") }
        execute(function)
    }

    private fun execute(action: (content: String) -> Unit) {
        println("start action")
        action("execute")
        println("end action")
    }
}