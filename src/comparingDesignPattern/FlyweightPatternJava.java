package comparingDesignPattern;

import java.util.HashMap;

public class FlyweightPatternJava {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight1 = flyweightFactory.getFlyweight("flyweight1");
        Flyweight flyweight2 = flyweightFactory.getFlyweight("flyweight2");
        Flyweight flyweight3 = flyweightFactory.getFlyweight("flyweight1");
        System.out.println(flyweight1 == flyweight2);
        System.out.println(flyweight1 == flyweight3);
    }
    static class Flyweight {
        private final String name;

        public Flyweight(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Flyweight(" + name + ")";
        }
    }
    static class FlyweightFactory {
        HashMap<String, Flyweight> flyweightHashMap = new HashMap<>();
        public Flyweight getFlyweight(String name) {
            return flyweightHashMap.computeIfAbsent(name, Flyweight::new);
        }
    }
}
