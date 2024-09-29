package designPattern;

public class PrototypePattern {
    public static void main(String[] args) {
        Plane plane1 = new Plane();
        System.out.println(plane1.getName());
        System.out.println(plane1.getType());
        Plane plane2 = (Plane) plane1.clone();
        System.out.println(plane2.getName());
        System.out.println(plane2.getType());
    }

    interface Prototype {
        Object clone();
    }

    static class Plane implements Prototype {
        private final String name;
        private final String type;

        public Plane() {
            name = "name_" + Math.random();
            type = "type_" + Math.random();
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        private Plane(Plane plane) {
            name = plane.name;
            type = plane.type;
        }

        @Override
        public Object clone() {
            return new Plane(this);
        }
    }
}