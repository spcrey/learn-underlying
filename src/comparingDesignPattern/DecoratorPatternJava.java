package comparingDesignPattern;

public class DecoratorPatternJava {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        concreteComponent.method();
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(concreteComponent);
        concreteDecorator.method();
        concreteDecorator.otherMethod();
    }

    interface Component {
        void method();
    }
    static class ConcreteComponent implements Component {
        @Override
        public void method() {
            System.out.println("ConcreteComponent.method()");
        }
    }
    static abstract class Decorator implements Component {
        protected final Component component;

        public Decorator(Component component) {
            this.component = component;
        }
    }
    static class ConcreteDecorator extends Decorator {
        public ConcreteDecorator(ConcreteComponent component) {
            super(component);
        }
        @Override
        public void method() {
            component.method();
        }
        void otherMethod() {
            System.out.println("ConcreteDecorator.otherMethod()");
        }
    }
}
