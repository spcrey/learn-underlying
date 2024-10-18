package comparingDesignPattern

object SimpleFactoryPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val factory = Factory()
        val productA = factory.createProduct("ProductA")
        productA.method()
        val productB = factory.createProduct("ProductB")
        productB.method()
        val productC = factory.createProduct("ProductC")
        productC.method()
    }

    abstract class Product {
        abstract fun method()
    }

    class ProductA : Product() {
        override fun method() {
            println("ProductA.method()")
        }
    }
    class ProductB : Product() {
        override fun method() {
            println("ProductB.method()")
        }
    }
    class ProductC : Product() {
        override fun method() {
            println("ProductC.method()")
        }
    }

    class Factory {
        fun createProduct(type: String) : Product {
            return when(type) {
                "ProductA" -> ProductA()
                "ProductB" -> ProductB()
                "ProductC" -> ProductC()
                else -> {
                    throw IllegalArgumentException("Invalid type")
                }
            }
        }
    }
}