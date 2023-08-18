package designpattern;

interface Product {
    void use();
}

class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductA");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductB");
    }
}

abstract class Creator {
    public abstract Product createProduct();
}

class ConcreteCreatorA extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

public class FactoryMethodMain {
    /***
     * In this example, Product is an interface that defines a method for using the product.
     * ConcreteProductA and ConcreteProductB are concrete implementations of the Product
     * interface that each implement their own version of the use method.
     *
     * Creator is an abstract class that defines a method for creating products.
     * ConcreteCreatorA and ConcreteCreatorB are concrete implementations of the
     * Creator class that each implement their own version of the createProduct method,
     * returning an instance of ConcreteProductA and ConcreteProductB, respectively.
     *
     * In the Main class, we create instances of ConcreteCreatorA and ConcreteCreatorB
     * and use them to create instances of ConcreteProductA and ConcreteProductB.
     * The use method is then called on each product to demonstrate that they can be used successfully.
     *
     * Note that the factory method pattern allows for the creation of different types of
     * products without changing the code that uses them.
     * The Creator class can be subclassed to create new products, and the code that uses
     * the products only needs to know about the Product interface, not the concrete implementations.
     * @param args
     */
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.createProduct();
        productA.use();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.createProduct();
        productB.use();
    }
}

/***
 * Difference between factory and factory method pattern
 * The Factory pattern and Factory Method pattern are two related design patterns that are often used in object-oriented programming to create objects.
 *
 * The Factory pattern is a creational pattern that provides an interface for creating objects in a super-factory, which is responsible for creating objects of various types based on the inputs it receives. The Factory pattern encapsulates the creation of objects and makes it easier to maintain and extend the code by separating the code that creates objects from the code that uses them.
 *
 * The Factory Method pattern is a variation of the Factory pattern that allows the factory to be subclassed to provide different ways of creating objects. In the Factory Method pattern, the responsibility of creating objects is delegated to a factory method, which is declared in an abstract base class and implemented by concrete subclasses. The concrete subclasses can decide which concrete class to instantiate and return as a product.
 *
 * In other words, the main difference between the Factory pattern and Factory Method pattern is that the Factory pattern has a single factory that creates different types of objects, while the Factory Method pattern has multiple factories (subclasses) that each create a specific type of object.
 *
 * Here's a summary of the key differences between the Factory pattern and Factory Method pattern:
 *
 * The Factory pattern has a single factory that creates different types of objects, while the Factory Method pattern has multiple factories (subclasses) that each create a specific type of object.
 * The Factory pattern uses a single method to create objects, while the Factory Method pattern uses a factory method that is declared in an abstract base class and implemented by concrete subclasses.
 * The Factory pattern is typically used when you need to create different types of objects at runtime, while the Factory Method pattern is typically used when you need to create a specific type of object based on some condition or input.
 * The Factory pattern encapsulates the creation of objects in a super-factory, while the Factory Method pattern delegates the responsibility of creating objects to its subclasses.
 * Both patterns are useful in different situations and can help to improve the modularity and flexibility of your code.
 */
