package comparingDesignPattern

object FactoryPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {

    }

    abstract class Product {
        abstract fun method()
    }
    abstract class Factory {
        abstract fun createProduct() : Product;
    }
    class ProductA : Product() {
        override fun method() {
            println("ProductA.method")
        }
    }
    class ProductB : Product() {
        override fun method() {
            println("ProductB.method")
        }
    }
}