package comparingDesignPattern

object TemplatePatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val concreteClassA: Template = ConcreteClassA()
        concreteClassA.method()
        val concreteClassB: Template = ConcreteClassB()
        concreteClassB.method()
    }
    abstract class Template {
        fun method() {
            step1()
            step2()
            step3()
        }
        protected open fun step1() {
            println("Template.step1()")
        }
        protected open fun step2() {
            println("Template.step2()")
        }
        protected open fun step3() {
            println("Template.step3()")
        }
    }
    class ConcreteClassA : Template() {
        override fun step1() {
            println("ConcreteClassA.step1()")
        }
        override fun step3() {
            println("ConcreteClassA.step3()")
        }
    }
    class ConcreteClassB : Template() {
        override fun step2() {
            println("ConcreteClassB.step2()")
        }
    }
}