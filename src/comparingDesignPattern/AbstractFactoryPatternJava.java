package comparingDesignPattern;

public class AbstractFactoryPatternJava {
    public static void main(String[] args) {
        Factory factory1 = new Factory1();
        Product a1 = factory1.createProductA();
        a1.method();
        Product b1 = factory1.createProductB();
        b1.method();
        Factory factory2 = new Factory2();
        Product a2 = factory2.createProductA();
        a2.method();
        Product b2 = factory2.createProductB();
        b2.method();
    }
    abstract static class Product {
        abstract void method();
    }
    abstract static class ProductA extends Product {}
    abstract static class ProductB extends Product {}
    static class Factory1ProductA extends ProductA {
        @Override
        void method() {
            System.out.println("ProductA1.method()");
        }
    }
    static class Factory2ProductA extends ProductA {
        @Override
        void method() {
            System.out.println("ProductA2.method()");
        }
    }
    static class Factory1ProductB extends ProductB {
        @Override
        void method() {
            System.out.println("ProductB1.method()");
        }
    }
    static class Factory2ProductB extends ProductB {
        @Override
        void method() {
            System.out.println("ProductB2.method()");
        }
    }
    abstract static class Factory {
        abstract ProductA createProductA();
        abstract ProductB createProductB();
    }
    static class Factory1 extends Factory {
        @Override
        Factory1ProductA createProductA() {
            return new Factory1ProductA();
        }
        @Override
        Factory1ProductB createProductB() {
            return new Factory1ProductB();
        }
    }
    static class Factory2 extends Factory {
        @Override
        Factory2ProductA createProductA() {
            return new Factory2ProductA();
        }
        @Override
        Factory2ProductB createProductB() {
            return new Factory2ProductB();
        }
    }
}
