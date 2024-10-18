package comparingDesignPattern;

public class StatePatternJava {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new StateA());
        context.action();
        context.setState(new StateB());
        context.action();
        context.setState(new StateC());
        context.action();
    }
    abstract static class State {
        abstract void action();
    }
    static class StateA extends State {
        @Override
        void action() {
            System.out.println("StateA.action()");
        }
    }
    static class StateB extends State {
        @Override
        void action() {
            System.out.println("StateB.action()");
        }
    }
    static class StateC extends State {
        @Override
        void action() {
            System.out.println("StateC.action()");
        }
    }
    static class Context {
        private State state;
        public Context(State state) {
            this.state = state;
        }
        public Context() {
            this.state = new StateA();
        }
        public void setState(State state) {
            this.state = state;
        }
        public void action() {
            state.action();
        }
    }
}
