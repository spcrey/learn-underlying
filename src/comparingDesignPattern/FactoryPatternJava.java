package comparingDesignPattern;

public class FactoryPatternJava {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.method();

        Factory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.method();
    }

    static abstract class Product {
        abstract void method();
    }
    static abstract class Factory{
        abstract Product createProduct();
    }
    static class ProductA extends Product{
        @Override
        void method() {
            System.out.println("ProductA");
        }
    }
    static class FactoryA extends Factory{
        @Override
        Product createProduct() {
            return new ProductA();
        }
    }
    static class ProductB extends Product{
        @Override
        void method() {
            System.out.println("ProductB");
        }
    }
    static class FactoryB extends Factory{
        @Override
        Product createProduct() {
            return new ProductB();
        }
    }
}
