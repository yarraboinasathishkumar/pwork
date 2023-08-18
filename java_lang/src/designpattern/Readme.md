## Type of design patterns
Design patterns can be classified into three main categories:

Creational patterns: These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. Creational patterns are used to create objects in a way that enhances flexibility and reuse of code.

Structural patterns: These patterns deal with object composition and class relationships. Structural patterns are used to define how objects are composed to form larger structures, such as class inheritance or object aggregation.

Behavioral patterns: These patterns deal with communication between objects and the delegation of responsibilities among them. Behavioral patterns are used to define how objects interact and how they are responsible for specific tasks.

Each category of design patterns contains a number of individual patterns that are specific to that category. For example, the Singleton pattern and Factory pattern are both examples of creational patterns, while the Adapter pattern and Facade pattern are examples of structural patterns, and the Observer pattern and Strategy pattern are examples of behavioral patterns.

Understanding and applying design patterns can help to improve code quality, maintainability, and reusability. By using design patterns, you can ensure that your code is well-structured, easy to read and maintain, and that it follows best practices for object-oriented design.

## Creational

Creational design patterns are a category of design patterns in object-oriented programming that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. There are five commonly recognized creational design patterns:

Singleton Pattern: Ensures that a class has only one instance and provides a global point of access to that instance.
Factory Method Pattern: Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
Abstract Factory Pattern: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
Builder Pattern: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
Prototype Pattern: Allows objects to be copied or cloned without being coupled to their concrete classes.
These patterns are widely used in software development to improve code quality, maintainability, and reusability. By using these patterns, you can ensure that your code is easy to read, maintain and extend, and that it follows best practices for object-oriented design.

## Aggregate vs Composition

Aggregate and composition are two types of object relationships in object-oriented programming. Here are the key differences between them:

Ownership: In a composition relationship, the parent object owns the child objects and is responsible for their lifetime. If the parent object is destroyed, the child objects are destroyed as well. In an aggregate relationship, the parent object has a reference to the child objects, but does not own them. The child objects may exist independently of the parent object.

Structure: In a composition relationship, the child objects form part of the structure of the parent object. The child objects are typically not shared with other objects. In an aggregate relationship, the child objects are typically shared with other objects and can belong to multiple parent objects.

Cardinality: In a composition relationship, the cardinality is typically one-to-many, meaning that each parent object has many child objects. In an aggregate relationship, the cardinality can be many-to-many, meaning that each child object can belong to many parent objects.

Here's an example to illustrate the difference:

// Composition example
class Car {
private Engine engine;
private List<Wheel> wheels;

    public Car() {
        this.engine = new Engine();
        this.wheels = new ArrayList<>();
        this.wheels.add(new Wheel());
        this.wheels.add(new Wheel());
        this.wheels.add(new Wheel());
        this.wheels.add(new Wheel());
    }
}

// Aggregate example
class Order {
private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}

In this example, Car is an example of a composition relationship. The Car object owns the Engine and Wheel objects and is responsible for their lifetime. The Order object, on the other hand, is an example of an aggregate relationship. The Order object has a list of Item objects, but does not own them. The Item objects can exist independently of the Order object and can belong to multiple orders.

Understanding the differences between aggregate and composition relationships is important in designing object-oriented systems that are modular, extensible, and maintainable.