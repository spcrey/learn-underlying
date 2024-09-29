package designPattern;

public class ProxyPattern {
    public static void main(String[] args) {
        Subject subject = new RealSubjectProxy();
        subject.doWork();
    }
    interface Subject {
        void doWork();
    }

    static class RealSubject implements Subject {
        public void doWork() {
            System.out.println("real subject do work");
        }
    }

    static class RealSubjectProxy implements Subject {
        private final RealSubject realSubject;

        public RealSubjectProxy() {
            realSubject = new RealSubject();
        }

        private void buildLink() {
            System.out.println("build link");
        }

        private void log() {
            System.out.println("log");
        }

        public void doWork() {
            buildLink();
            realSubject.doWork();
            log();
        }
    }
}
