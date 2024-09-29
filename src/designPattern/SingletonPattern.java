package designPattern;

public class SingletonPattern {
    public static void main(){
        SingleObject single1 = SingleObject.getInstance(1);
        single1.showIndex();
        SingleObject single2 = SingleObject.getInstance(2);
        single2.showIndex();
    }

    static class SingleObject {
        private static volatile SingleObject instance;
        private final int index;
        private SingleObject(int index){
            this.index = index;
        }
        public static SingleObject getInstance(int index){
            if(instance == null) {
                synchronized (SingleObject.class) {
                    if(instance==null) {
                        instance = new SingleObject(index);
                    }
                }
            }
            return instance;
        }
        public void showIndex(){
            System.out.println(this.index);
        }
    }
}
