package comparingDesignPattern;

public class SingletonPatternJava {
    public static void main(String[] args) {
        HungrySingleton s1 = HungrySingleton.getInstance();
        System.out.println(s1);
        LazySingleton s2 = LazySingleton.getInstance("s2");
        System.out.println(s2);
        LazySingleton s3 = LazySingleton.getInstance("s3");
        System.out.println(s3);
        DoubleCheckedLockingEagerSingleton s4 = DoubleCheckedLockingEagerSingleton.getInstance("s4");
        System.out.println(s4);
        DoubleCheckedLockingEagerSingleton s5 = DoubleCheckedLockingEagerSingleton.getInstance("s5");
        System.out.println(s5);
    }

    static class LazySingleton {
        private static LazySingleton instance = null;
        private final String name;

        private LazySingleton(String name) {
            this.name = name;
        }
        public static synchronized LazySingleton getInstance(String name) {
            if (instance == null) {
                instance = new LazySingleton(name);
            }
            return instance;
        }
        @Override
        public String toString() {
            return "LazySingleton(" + name + ")";
        }
    }

    static class HungrySingleton {
        private static final HungrySingleton instance = new HungrySingleton();
        private HungrySingleton() {}

        @Override
        public String toString() {
            return "HungrySingleton()";
        }
        public static HungrySingleton getInstance() {
            return instance;
        }
    }

    static class DoubleCheckedLockingEagerSingleton {
        private static volatile DoubleCheckedLockingEagerSingleton instance = null;
        private final String name;

        private DoubleCheckedLockingEagerSingleton(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "DoubleCheckedLockingEagerSingleton(" + name + ")";
        }
        public static DoubleCheckedLockingEagerSingleton getInstance(String name) {
            if (instance == null) {
                synchronized (DoubleCheckedLockingEagerSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckedLockingEagerSingleton(name);
                    }
                }
            }
            return instance;
        }
    }
}
