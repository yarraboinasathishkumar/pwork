package designpattern;

// Abstraction
abstract class BridgeShape {
    protected Color color;

    public BridgeShape(Color color) {
        this.color = color;
    }

    public abstract void applyColor();
}

// Refined Abstraction
class BridgeCircle extends BridgeShape {
    private int radius;

    public BridgeCircle(int radius, Color color) {
        super(color);
        this.radius = radius;
    }

    public void applyColor() {
        System.out.print("Circle filled with color ");
        color.applyColor();
    }
}

// Refined Abstraction
class Square extends BridgeShape {
    private int length;

    public Square(int length, Color color) {
        super(color);
        this.length = length;
    }

    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }
}

// Implementor
interface Color {
    public void applyColor();
}

// Concrete Implementor
class Red implements Color {
    public void applyColor() {
        System.out.println("Red");
    }
}

// Concrete Implementor
class Blue implements Color {
    public void applyColor() {
        System.out.println("Blue");
    }
}

// Client code
public class BridgeClient {
    /***
     * Note: consider Shape class BridgeShape, Circle class as BridgeCircle in the below paragraph to link with code.
     *
     * In this example, the Bridge pattern is used to separate the abstraction (Shape) from its implementation (Color).
     * The Shape class represents the abstraction, while the Color interface represents the implementor.
     *
     * The Circle and Square classes are concrete implementations of the Shape abstraction.
     * They take a Color object as a parameter and delegate the applyColor() method to
     * the Color object to apply the color.
     *
     * The Red and Blue classes are concrete implementations of the Color interface.
     * They provide the specific implementations of the applyColor() method.
     *
     * The client code creates instances of Circle and Square, passing the appropriate Color object,
     * and calls the applyColor() method to apply the color to the shapes.
     *
     * By using the Bridge pattern, we achieve a flexible and decoupled design where the abstraction and
     * implementation can vary independently. It allows adding new shapes or colors without modifying the existing code,
     * promoting code reusability and maintainability.
     * @param args
     */
    public static void main(String[] args) {
        BridgeShape redCircle = new BridgeCircle(5, new Red());
        BridgeShape blueSquare = new Square(10, new Blue());

        redCircle.applyColor();   // Output: Circle filled with color Red
        blueSquare.applyColor();  // Output: Square filled with color Blue
    }
}

