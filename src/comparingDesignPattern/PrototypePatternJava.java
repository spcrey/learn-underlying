package comparingDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class PrototypePatternJava {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Cloneable cloneable = new Cloneable(1, list);
        System.out.println(cloneable);
        Cloneable cloner = (Cloneable) cloneable.clone();
        cloneable.setNum(2);
        cloneable.list.set(2, "5");
        System.out.println(cloner);
    }
    static class Cloneable {
        private int num;
        public final List<String> list;
        Cloneable(int value, List<String> list) {
            this.num = value;
            this.list = list;
        }
        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Prototype(" + num + ", " + list + ")";
        }

        @Override
        public Object clone(){
            return new Cloneable(
                    num,
                    new ArrayList<>(list)
            );
        }
    }
}
