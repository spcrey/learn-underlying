package comparingDesignPattern;

public class TemplatePatternJava {
    public static void main(String[] args) {
        Template concreteClassA = new ConcreteClassA();
        concreteClassA.method();
        Template concreteClassB = new ConcreteClassB();
        concreteClassB.method();
    }
    abstract static class Template {
        public void method() {
            step1();
            step2();
            step3();
        }
        protected void step1() {
            System.out.println("Template.step1()");
        }
        protected void step2() {
            System.out.println("Template.step2()");
        }
        protected void step3() {
            System.out.println("Template.step3()");
        }
    }
    static class ConcreteClassA extends Template {
        @Override
        protected void step1() {
            System.out.println("ConcreteClassA.step1()");
        }

        @Override
        protected void step3() {
            System.out.println("ConcreteClassA.step3()");
        }
    }
    static class ConcreteClassB extends Template {
        @Override
        protected void step2() {
            System.out.println("ConcreteClassB.step2()");
        }
    }
}
