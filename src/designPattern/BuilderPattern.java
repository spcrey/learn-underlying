package designPattern;

public class BuilderPattern {
    public static void main(String[] args) {
        Window window = new Window("window");
        Door door = new Door("door");
        Wall wall = new Wall("wall");
        House house = new House("house", window, door, wall);
        house.print();
    }

    static class Window {
        private final String name;
        public Window(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    static class Door {
        private final String name;
        public Door(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    static class Wall {
        private final String name;
        public Wall(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    static class House {
        String name;
        private final Window window;
        private final Door door;
        private final Wall wall;
        public House(String name, Window window, Door door, Wall wall) {
            this.name = name;
            this.window = window;
            this.door = door;
            this.wall = wall;
        }
        public void print() {
            System.out.println(
                    name + ": " +
                            window.getName() + ", " +
                            door.getName() + ", " +
                            wall.getName()
            );
        }
    }
}

