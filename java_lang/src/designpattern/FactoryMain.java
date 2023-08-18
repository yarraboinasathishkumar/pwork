package designpattern;

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

public class FactoryMain {
    /***
     * In this example, Shape is an interface that defines a method for drawing the shape.
     * Circle and Rectangle are concrete implementations of the Shape interface
     * that each implement their own version of the draw method.
     *
     * ShapeFactory is a factory class that creates Shape objects based on a string input.
     * In this example, we have two possible shapes that can be created: Circle and Rectangle.
     * The getShape method takes a string parameter that represents the type of shape
     * to be created, and returns a Shape object of the corresponding type.
     * If an unsupported shape type is requested, the method returns null.
     *
     * In the Main class, we create a ShapeFactory object and use it to create
     * instances of Circle and Rectangle. The draw method is then called on each shape
     * to demonstrate that they can be drawn successfully.
     * @param args
     */
    public static void main(String[] args) {
        ShapeFactory flyweightShapeFactory = new ShapeFactory();

        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
