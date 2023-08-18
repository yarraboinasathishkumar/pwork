package designpattern;

// Singleton class
class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
    }

    // Public static method to provide the global access point to the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Other methods of the Singleton class
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }
}

// Client code
public class SingletonClient {
    /***
     * In this example, the Singleton design pattern is used to ensure that only one instance of a class is
     * created and provide a global access point to it.
     *
     * The Singleton class has a private constructor, preventing direct instantiation from outside
     * the class. The class also has a private static instance variable to hold the single instance of the class.
     *
     * The getInstance() method is the public static method that provides the global access point to the
     * Singleton instance. It uses double-checked locking to ensure thread-safety during the creation of the instance.
     * The first time it is called, it creates a new instance of the Singleton class. On subsequent calls,
     * it returns the existing instance.
     *
     * The client code demonstrates the usage of the Singleton pattern. It tries to create an instance of
     * the Singleton class using the new operator, which results in a compilation error since the
     * constructor is private. Instead, it calls the getInstance() method to get the Singleton instance and
     * performs some operations using that instance.
     *
     * By using the Singleton pattern, we can ensure that only one instance of a class exists in the
     * system and provide a single point of access to that instance. It is commonly used in scenarios where
     * having multiple instances of a class can cause issues or inefficiencies, such as managing shared resources,
     * configuration settings, or logging mechanisms.
     * @param args
     */
    public static void main(String[] args) {
        // The Singleton class cannot be instantiated directly
        // Singleton singleton = new Singleton(); // Error: The constructor Singleton() is not visible

        // Get the Singleton instance using the getInstance() method
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
