package designPattern;

import java.util.HashMap;

public class FlyweightPattern {
    public static void main(String[] args) {
        Circle circle1 = CircleFactory.getCircle("red");
        Circle circle2 = CircleFactory.getCircle("blue");
        Circle circle3 = CircleFactory.getCircle("green");
        Circle circle4 = CircleFactory.getCircle("red");
        System.out.println(circle1 == circle2);
        System.out.println(circle1 == circle3);
        System.out.println(circle1 == circle4);
    }

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        private String color;

        public Circle(String color) {
            this.color = color;
        }

        @Override
        public void draw() {
            System.out.println("draw " + this.color + " circle");
        }
    }

    static class CircleFactory {
        private static final HashMap<String, Circle> circleMap = new HashMap<>();

        public static Circle getCircle(String color) {
            Circle circle = (Circle)circleMap.get(color);
            if(circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
            }
            return circle;
        }
    }

}
