package designPattern;

public class ResponsibilityChainPattern {
    public static void main(String[] args) {
        Handler leader = new Leader();
        Handler boss = new Boss();
        Handler executor = new Executor();
        leader.setNextHandler(boss);
        boss.setNextHandler(executor);
        leader.process(2000);
    }

    abstract static class Handler {
        protected Handler nextHandler;
        public void setNextHandler(Handler handler) {
            this.nextHandler = handler;
        }
        abstract public void process(Integer info);
    }

    static class Leader extends Handler {
        @Override
        public void process(Integer info) {
            if (info > 0 && info < 10) {
                System.out.println("leader process");
            }
            else {
                this.nextHandler.process(info);
            }
        }
    }

    static class Boss extends Handler {
        @Override
        public void process(Integer info) {
            if (info < 20) {
                System.out.println("Boss process");
            }
            else {
                this.nextHandler.process(info);
            }
        }
    }

    static class Executor extends Handler {
        @Override
        public void process(Integer info) {
            System.out.println("Executor process");
        }
    }
}
