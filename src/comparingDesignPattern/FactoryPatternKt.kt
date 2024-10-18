package comparingDesignPattern

object FactoryPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val factoryA = FactoryA()
        val productA = factoryA.createProduct()
        productA.method()
        val factoryB = FactoryB()
        val productB = factoryB.createProduct()
        productB.method()
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
    class FactoryA : Factory() {
        override fun createProduct(): ProductA {
            return ProductA()
        }
    }
    class ProductB : Product() {
        override fun method() {
            println("ProductB.method")
        }
    }
    class FactoryB : Factory() {
        override fun createProduct(): ProductB {
            return ProductB()
        }
    }
}