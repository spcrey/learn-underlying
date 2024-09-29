package designPattern;

public class FacadePattern {
    public static void main(String[] args) {
        Step step = new FullStep();
        step.step();
    }

    interface Step {
        void step();
    }

    static class SubStep1 implements Step {
        @Override
        public void step() {
            System.out.println("SubStep1");
        }
    }

    static class SubStep2 implements Step {
        @Override
        public void step() {
            System.out.println("SubStep2");
        }
    }

    static class SubStep3 implements Step {
        @Override
        public void step() {
            System.out.println("SubStep3");
        }
    }

    static class FullStep implements Step {
        private final Step subStep1 = new SubStep1();
        private final Step subStep2 = new SubStep2();
        private final Step subStep3 = new SubStep3();
        @Override
        public void step() {
            subStep1.step();
            subStep2.step();
            subStep3.step();
        }
    }
}
