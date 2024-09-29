public class ProducerConsumerPattern {
    public static void main(String[] args) {
        ThreadManager tm = new ThreadManager();
        tm.run();
    }

    static class ThreadManager {

        public void run() {
            threadNum.start();
            threadAlpha.start();
            try {
                threadNum.join();
                threadAlpha.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        private final ProducerConsumer producerConsumer = new ProducerConsumer();

        private final Thread threadNum = new Thread(() -> {
            for (int i=0; i<=26; i++) {
                producerConsumer.producer(i);
            }
        });

        private final Thread threadAlpha = new Thread(() -> {
            for (int i='a'; i<='z'; i++) {
                producerConsumer.consumer((char)i);
            }
        });
    }

    static class ProducerConsumer {
        private int status = 0;

        public synchronized void producer(int i) {
            if (status==0) {
                try {
                    this.wait();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            status = 0;
            System.out.print(i);
            this.notify();
        }

        public synchronized void consumer(char alpha) {
            if (status==1) {
                try {
                    this.wait();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            status = 1;
            System.out.print(alpha);
            this.notify();
        }
    }
}
