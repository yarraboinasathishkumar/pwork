package designpattern;

// Prototype interface
interface Prototype {
    public Prototype clone();
}

// Concrete Prototypes
class PrototypeCircle implements Prototype {
    private int x, y;
    private int radius;

    public PrototypeCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Prototype clone() {
        return new PrototypeCircle(x, y, radius);
    }

    public String toString() {
        return "Circle - x: " + x + ", y: " + y + ", radius: " + radius;
    }
}

class PrototypeRectangle implements Prototype {
    private int width, height;

    public PrototypeRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Prototype clone() {
        return new PrototypeRectangle(width, height);
    }

    public String toString() {
        return "Rectangle - width: " + width + ", height: " + height;
    }
}

// Client code
public class PrototypeClient {
    /***
     * In this example, the Prototype design pattern is used to create copies (clones) of objects.
     *
     * The Prototype interface declares the clone() method, which returns a clone of the object.
     *
     * The Circle and Rectangle classes are concrete prototypes that implement the Prototype interface.
     * They define their own clone method by creating a new instance of themselves with the same attribute values.
     *
     * The client code demonstrates the usage of the Prototype pattern. It creates instances of Circle and Rectangle
     * objects. It then clones the objects by calling the clone() method, which creates copies of the original objects.
     * Finally, it prints the original and cloned objects to demonstrate that they are separate instances.
     *
     * By using the Prototype pattern, we can create new objects by cloning existing objects, avoiding the need
     * to create objects from scratch. It provides a convenient and efficient way to create object
     * copies while preserving their original state.
     * @param args
     */
    public static void main(String[] args) {
        PrototypeCircle circle = new PrototypeCircle(10, 20, 5);
        PrototypeCircle clonedCircle = (PrototypeCircle) circle.clone();
        System.out.println(circle);
        System.out.println(clonedCircle);

        PrototypeRectangle rectangle = new PrototypeRectangle(15, 30);
        PrototypeRectangle clonedRectangle = (PrototypeRectangle) rectangle.clone();
        System.out.println(rectangle);
        System.out.println(clonedRectangle);
    }
}
