package designpattern;

// Abstract class defining the template method
abstract class AbstractClass {
    // Template method
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void step1();
    protected abstract void step2();

    // Default implementation of step3
    protected void step3() {
        System.out.println("Default implementation of step3");
    }
}

// Concrete class implementing the template methods
class ConcreteClass extends AbstractClass {
    protected void step1() {
        System.out.println("Performing step1");
    }

    protected void step2() {
        System.out.println("Performing step2");
    }

    // Overriding the default implementation of step3
    protected void step3() {
        System.out.println("Performing custom step3");
    }
}

// Client code
public class TemplateMethodClient {
    /***
     * In this example, the Template Method design pattern is used to define the skeleton of an algorithm in an
     * abstract class, allowing subclasses to provide specific implementations for certain steps
     * while keeping the overall structure intact.
     *
     * The AbstractClass is an abstract class that defines the template method templateMethod().
     * This method calls several steps in a specific order, including step1(), step2(), and step3(). step1()
     * and step2() are abstract methods that must be implemented by subclasses, while step3() has a
     * default implementation that can be optionally overridden.
     *
     * The ConcreteClass is a concrete subclass that extends AbstractClass and provides specific implementations
     * for step1() and step2(). It also overrides the default implementation of step3() to
     * provide a custom implementation.
     *
     * The client code creates an instance of ConcreteClass and calls the templateMethod().
     * This triggers the execution of the algorithm defined in the template method, with each
     * step being executed in the specified order.
     *
     * By using the Template Method pattern, we can define a common algorithm structure in an abstract class,
     * allowing subclasses to implement specific steps as needed. It promotes code reuse, encapsulates common
     * behavior, and provides a consistent approach to implementing algorithms.
     * @param args
     */
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
