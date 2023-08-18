package designpattern;

// Element interface
interface Element {
    void accept(Visitor visitor);
}

// Concrete Elements
class VCircle implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class VSquare implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Visitor interface
interface Visitor {
    void visit(VCircle circle);
    void visit(VSquare square);
}

// Concrete Visitors
class DrawingVisitor implements Visitor {
    public void visit(VCircle circle) {
        System.out.println("Drawing operation on circle");
        circle.draw();
    }

    public void visit(VSquare square) {
        System.out.println("Drawing operation on square");
        square.draw();
    }
}

class ErasingVisitor implements Visitor {
    public void visit(VCircle circle) {
        System.out.println("Erasing operation on circle");
    }

    public void visit(VSquare square) {
        System.out.println("Erasing operation on square");
    }
}

// Client code
public class VisitorClient {
    /***
     * In this example, the Visitor design pattern is used to separate the operations (visitors) from the objects
     * (elements) they operate on, enabling new operations to be added without modifying the objects.
     *
     * The Element interface represents the elements that can be visited. It defines the accept()
     * method to accept a visitor.
     *
     * The Circle and Square classes are concrete elements that implement the Element interface.
     * They provide their specific implementations of the accept() method and have their own
     * operations (draw() in this case).
     *
     * The Visitor interface declares the visit methods for each concrete element.
     *
     * The DrawingVisitor and ErasingVisitor classes are concrete visitors that implement the Visitor interface.
     * They provide the specific implementations of the visit methods for each concrete element. In this example,
     * the DrawingVisitor performs drawing operations, while the ErasingVisitor performs erasing operations.
     *
     * The client code creates an array of elements (Circle and Square). It then creates instances of the
     * visitors (DrawingVisitor and ErasingVisitor). It iterates over the elements and calls the accept()
     * method on each element, passing the appropriate visitor. This triggers the execution of the corresponding
     * visit method in the visitor.
     *
     * By using the Visitor pattern, we can separate the operations performed on elements into separate
     * visitor classes, avoiding the need to modify the element classes themselves.
     * It promotes extensibility by allowing new operations to be added easily without modifying the elements.
     * Additionally, it enables operations to work on multiple elements with different types by
     * utilizing dynamic dispatch through the accept method.
     * @param args
     */
    public static void main(String[] args) {
        Element[] elements = { new VCircle(), new VSquare() };

        Visitor drawingVisitor = new DrawingVisitor();
        Visitor erasingVisitor = new ErasingVisitor();

        for (Element element : elements) {
            element.accept(drawingVisitor);
            element.accept(erasingVisitor);
        }
    }
}
