package comparingDesignPattern

object AbstractFactoryPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val factory1 = Factory1()
        val a1 = factory1.createProductA()
        a1.method()
        val b1 = factory1.createProductB()
        b1.method()
        val factory2 = Factory2()
        val a2 = factory2.createProductA()
        a2.method()
        val b2 = factory2.createProductB()
        b2.method()
    }
    abstract class Product {
        abstract fun method()
    }
    abstract class ProductA : Product()
    abstract class ProductB : ProductA()
    abstract class Factory {
        abstract fun createProductA(): ProductA
        abstract fun createProductB(): ProductB
    }
    class Factory1ProductA : ProductA() {
        override fun method() {
            println("Factory1ProductA.method()")
        }
    }
    class Factory2ProductA : ProductB() {
        override fun method() {
            println("Factory2ProductA.method()")
        }
    }
    class Factory1ProductB : ProductB() {
        override fun method() {
            println("Factory1ProductB.method()")
        }
    }
    class Factory2ProductB : ProductB() {
        override fun method() {
            println("Factory2ProductB.method()")
        }
    }
    class Factory1 : Factory() {
        override fun createProductA(): Factory1ProductA {
            return Factory1ProductA()
        }
        override fun createProductB(): Factory1ProductB {
            return Factory1ProductB()
        }
    }
    class Factory2 : Factory() {
        override fun createProductA(): Factory2ProductA {
            return Factory2ProductA()
        }
        override fun createProductB(): Factory2ProductB {
            return Factory2ProductB()
        }
    }
}