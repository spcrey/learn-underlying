package designPattern;

public class DecoratorPattern {
    public static void main(String[] args){
        Shape shape = new RedShapeDecorator(new Circle());
        shape.draw();
    }

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw(){
            System.out.println("Circle.draw");
        }
    }

    static class Rectangle implements Shape {
        public void draw(){
            System.out.println("Rectangle.draw");
        }
    }

    abstract static class ShapeDecorator implements Shape {
        public ShapeDecorator(Shape shape){
            this.shape = shape;
        }
        protected Shape shape;
    }

    static class RedShapeDecorator extends ShapeDecorator {
        public RedShapeDecorator(Shape shape){
            super(shape);
        }
        public void draw(){
            this.setRedBorder();
        }
        public void setRedBorder(){
            System.out.println("RedShapeDecorator.setRedBorder");
        }
    }
}


