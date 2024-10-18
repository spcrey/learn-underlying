package comparingDesignPattern

object FacadePatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val facade = Facade()
        facade.step()
    }
    class Facade {
        fun step(): Boolean {
            if (step1() && step2() && step3()) {
                println("Facade.step()")
                return true
            } else {
                return false
            }
        }
        private fun step1(): Boolean {
            println("Facade.step1()")
            return true
        }
        private fun step2(): Boolean {
            println("Facade.step2()")
            return true
        }
        private fun step3(): Boolean {
            println("Facade.step3()")
            return true
        }
    }
}