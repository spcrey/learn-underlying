package designPattern;

public class TemplatePattern {
    public static void main(String[] args) {
        Cooking cooking = new ConcreteCooking();
        cooking.cook();
    }

    abstract static class Cooking {
        abstract protected void step1();
        abstract protected void step2();
        public void cook() {
            System.out.println("cooking start");
            step1();
            step2();
            System.out.println("cooking end");
        }
    }

    static class ConcreteCooking extends Cooking {
        @Override
        protected void step1() {
            System.out.println("cooking concrete 1");
        }

        @Override
        protected void step2() {
            System.out.println("cooking concrete 2");
        }
    }
}
