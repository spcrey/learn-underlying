package designPattern;

public class StatePattern {
    public static void main(String[] args) {
        State happy = new Happy();
        State angry = new Angry();
        State sad = new Sad();
        ZhangSan zhang3 = new ZhangSan(happy);
        zhang3.doWork();
        zhang3.changeState(angry);
        zhang3.doWork();
        zhang3.changeState(sad);
        zhang3.doWork();
    }

    interface State {
        void doWork();
    }

    static class Happy implements State {
        public void doWork() {
            System.out.println("want to do more things");
        }
    }

    static class Angry implements State {
        public void doWork() {
            System.out.println("don't want to do things");
        }
    }

    static class Sad implements State {
        public void doWork() {
            System.out.println("won't do any things");
        }
    }

    static class ZhangSan {
        private State state;
        public ZhangSan(State state){
            this.state = state;
        }
        public void changeState(State state){
            this.state = state;
        }
        public void doWork() {
            state.doWork();
        }
    }
}
