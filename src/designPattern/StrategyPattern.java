package designPattern;

public class StrategyPattern {
    public static void main(String[] args) {
        Strategy addStrategy = new AddStrategy();
        Strategy minusStrategy = new MinusStrategy();
        Strategy multiplicationStrategy = new MultiplicationStrategy();
        int num1 = 2;
        int num2 = 4;
        Context context = new Context(addStrategy);
        System.out.println(context.execute(num1, num2));
        context.changeStrategy(minusStrategy);
        System.out.println(context.execute(num1, num2));
        context.changeStrategy(multiplicationStrategy);
        System.out.println(context.execute(num1, num2));
    }

    interface Strategy {
        int execute(int num1, int num2);
    }

    static class AddStrategy implements Strategy {
        @Override
        public int execute(int num1, int num2) {
            return num1 + num2;
        }
    }

    static class MinusStrategy implements Strategy {
        @Override
        public int execute(int num1, int num2) {
            return num1 - num2;
        }
    }

    static class MultiplicationStrategy implements Strategy {
        @Override
        public int execute(int num1, int num2) {
            return num1 * num2;
        }
    }

    static class Context {
        private Strategy strategy;
        public Context(Strategy strategy) {
            this.strategy = strategy;
        }
        public void changeStrategy(Strategy strategy) {
            this.strategy = strategy;
        }
        public int execute(int num1, int num2) {
            return strategy.execute(num1, num2);
        }
    }

}
