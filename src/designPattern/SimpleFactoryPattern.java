package designPattern;

import java.util.Objects;

public class SimpleFactoryPattern {
    public static void main(String[] args){
        Factory factory = new Factory();
        Product productA = factory.createProduct("A");
        productA.method();
        Product productB = factory.createProduct("B");
        productB.method();
    }

    interface Product {
        void method();
    }

    static class ProductA implements Product{
        @Override
        public void method(){
            System.out.println("product A method");
        }
    }

    static class ProductB implements Product{
        @Override
        public void method(){
            System.out.println("product B method");
        }
    }

    static class Factory {
        public Product createProduct(String productName){
            if(Objects.equals(productName, "A"))
                return new ProductA();
            else if(Objects.equals(productName, "B"))
                return new ProductB();
            else
                throw new IllegalArgumentException("no product named " + productName);
        }
    }
}
