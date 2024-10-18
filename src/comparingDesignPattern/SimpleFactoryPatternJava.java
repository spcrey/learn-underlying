package comparingDesignPattern;

public class SimpleFactoryPatternJava {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Product productA = factory.createProduct("ProductA");
        productA.method();
        Product productB = factory.createProduct("ProductB");
        productB.method();
        Product productC = factory.createProduct("ProductC");
        productC.method();
    }

    abstract static class Product {
        abstract void method();
    }
    static class ProductA extends Product {
        @Override
        void method() {
            System.out.println("ProductA.method()");
        }
    }
    static class ProductB extends Product {
        @Override
        void method() {
            System.out.println("ProductB.method()");
        }
    }
    static class ProductC extends Product {
        @Override
        void method() {
            System.out.println("ProductC.method()");
        }
    }

    static class Factory {
        public Product createProduct(String type) {
            return switch (type) {
                case "ProductA" -> new ProductA();
                case "ProductB" -> new ProductB();
                case "ProductC" -> new ProductC();
                default -> throw new IllegalArgumentException("Invalid type");
            };
        }
    }
}
