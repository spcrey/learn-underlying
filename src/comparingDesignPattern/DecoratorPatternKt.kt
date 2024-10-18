package comparingDesignPattern

object DecoratorPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val concreteComponent = ConcreteComponent()
        concreteComponent.method()
        val concreteDecorator = ConcreteDecorator(concreteComponent)
        concreteDecorator.method()
        concreteDecorator.otherMethod()
        concreteComponent.extensionMethod()
    }
    interface Component {
        abstract fun method()
    }
    abstract class Decorator(protected val component: Component) : Component

    class ConcreteComponent : Component {
        override fun method() {
            println("ConcreteComponent.method()")
        }
    }
    class ConcreteDecorator(component: ConcreteComponent) : Decorator(component) {
        override fun method() {
            component.method()
        }
        fun otherMethod() {
            println("ConcreteDecorator.otherMethod()")
        }
    }
    private fun ConcreteComponent.extensionMethod() {
        println("ConcreteComponent.extensionMethod()")
    }
}