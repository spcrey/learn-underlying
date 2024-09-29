public class JoinByWaitNotify {
    public static void main(String[] args) {
        ThreadManage threadManage = new ThreadManage();
        threadManage.run();
    }

    static class ThreadNum {
        public int num = 0;
    }


    static class ThreadManage {
        final ThreadNum lock = new ThreadNum();

        public void run() {
            System.out.println("start");
            thread1.start();
            thread2.start();
            thread3.start();

            // try {
            //     thread.join();
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            synchronized(lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("finish");
        }

        final Thread thread1 = new Thread(() -> {
            for (int i=0; i<3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            synchronized(lock) {
                lock.num += 1;
                if (lock.num == 3) {
                    lock.notify();
                }
            }
        });

        final Thread thread2 = new Thread(() -> {
            for (int i=3; i<6; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            synchronized(lock) {
                lock.num += 1;
                if (lock.num == 3) {
                    lock.notify();
                }
            }
        });

        final Thread thread3 = new Thread(() -> {
            for (int i=6; i<10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            synchronized(lock) {
                lock.num += 1;
                if (lock.num == 3) {
                    lock.notify();
                }
            }
        });
    }
}
