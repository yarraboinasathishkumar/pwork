package designpattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface FlyweightShape {
    public void draw();
}

// Concrete Flyweight
class FlyweightCircle implements FlyweightShape {
    private String color;

    public FlyweightCircle(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("Drawing a circle with color: " + color);
    }
}

// Flyweight Factory
class FlyweightShapeFactory {
    private static Map<String, FlyweightShape> shapeMap = new HashMap<>();

    public static FlyweightShape getCircle(String color) {
        FlyweightShape circle = shapeMap.get(color);

        if (circle == null) {
            circle = new FlyweightCircle(color);
            shapeMap.put(color, circle);
        }

        return circle;
    }
}

// Client code
public class FlyweightClient {
    /***
     * In this example, the Flyweight design pattern is used to minimize memory usage by sharing objects
     * with similar intrinsic properties.
     *
     * The Shape interface represents the flyweight object, which has an intrinsic property, in this case, the color.
     * It declares the draw() method to draw the shape.
     *
     * The Circle class is a concrete flyweight object that implements the Shape interface.
     * It has a color attribute and implements the draw() method to draw a circle with the specified color.
     *
     * The ShapeFactory class is the flyweight factory that maintains a pool of flyweight objects.
     * It has a static shapeMap that maps colors to flyweight objects. The getCircle() method checks
     * if a circle with the specified color exists in the map. If it does, it returns the existing circle; otherwise,
     * it creates a new circle, adds it to the map, and returns it.
     *
     * The client code demonstrates the usage of the flyweight objects. It randomly selects colors
     * from an array and gets a circle from the ShapeFactory by specifying the color.
     * It then calls the draw() method on the circle to draw it.
     *
     * By using the Flyweight pattern, we can share objects with similar intrinsic properties,
     * reducing memory usage and improving performance. In this example, circles with different colors are
     * created and reused, minimizing the number of circle objects created.
     */
    private static final String[] colors = { "Red", "Green", "Blue", "Yellow", "Black" };

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String color = colors[(int) (Math.random() * colors.length)];
            FlyweightCircle flyweightCircle = (FlyweightCircle) FlyweightShapeFactory.getCircle(color);
            flyweightCircle.draw();
        }
    }
}
