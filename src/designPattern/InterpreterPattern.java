package designPattern;

public class InterpreterPattern {
    public static void main(String[] args) {
        // expression: 1 + 5 - 4
        Expression expression = new MinusExpression(
                new AddExpression(
                        new NumberExpression(1),
                        new NumberExpression(5)
                ),
                new NumberExpression(4)
        );
        System.out.println(expression.interpret());
    }

    interface Expression {
        int interpret();
    }

    static class NumberExpression implements Expression {
        private final int number;

        public NumberExpression(int number) {
            this.number = number;
        }

        @Override
        public int interpret() {
            return number;
        }
    }

    static class AddExpression implements Expression {
        private final Expression left;
        private final Expression right;

        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return this.left.interpret() + this.right.interpret();
        }
    }

    static class MinusExpression implements Expression {
        private final Expression left;
        private final Expression right;

        public MinusExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int interpret() {
            return this.left.interpret() - this.right.interpret();
        }
    }
}
