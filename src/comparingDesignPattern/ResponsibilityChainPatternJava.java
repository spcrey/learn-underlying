package comparingDesignPattern;

public class ResponsibilityChainPatternJava {
    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();
        handlerA.setNext(handlerB);
        handlerB.setNext(handlerC);
        handlerA.handleRequest(1);
    }
    abstract static class Handler {
        protected Handler next;
        public void setNext(Handler next) {
            this.next = next;
        }
        public abstract void handleRequest(int num);
    }
    static class HandlerA extends Handler {
        @Override
        public void handleRequest(int num) {
            if (num < 10) {
                System.out.println("HandlerA.handleRequest()");
            } else {
                if (next != null) {
                    next.handleRequest(num);
                }
            }
        }
    }
    static class HandlerB extends Handler {
        @Override
        public void handleRequest(int num) {
            if (num < 100) {
                System.out.println("HandlerB.handleRequest()");
            } else {
                if (next != null) {
                    next.handleRequest(num);
                }
            }
        }
    }
    static class HandlerC extends Handler {
        @Override
        public void handleRequest(int num) {
            if (num < 1000) {
                System.out.println("HandlerC.handleRequest()");
            } else {
                if (next != null) {
                    next.handleRequest(num);
                }
            }
        }
    }

}
