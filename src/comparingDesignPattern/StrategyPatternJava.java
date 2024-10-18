package comparingDesignPattern;

public class StrategyPatternJava {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new StrategyA());
        context.execute(1,2);
        context.setStrategy(new StrategyB());
        context.execute(1,2);
    }
    static abstract class Strategy {
        abstract int execute(int a, int b);
    }
    static class Context {
        Strategy strategy;
        public Context(Strategy strategy) {
            this.strategy = strategy;
        }
        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public Context() {
            this.strategy = new StrategyA();
        }
        public void execute(int a, int b) {
            System.out.println(strategy.execute(a, b));
        }
    }
    static class StrategyA extends Strategy {
        @Override
        int execute(int a, int b) {
            System.out.println("StrategyA.execute()");
            return a + b;
        }
    }
    static class StrategyB extends Strategy {
        @Override
        int execute(int a, int b) {
            System.out.println("StrategyB.execute()");
            return a - b;
        }
    }
}
