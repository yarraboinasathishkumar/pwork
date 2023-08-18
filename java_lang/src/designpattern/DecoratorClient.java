package designpattern;

// Component interface
interface Pizza {
    public String getDescription();
    public double getCost();
}

// Concrete Component
class MargheritaPizza implements Pizza {
    public String getDescription() {
        return "Margherita Pizza";
    }

    public double getCost() {
        return 6.99;
    }
}

// Decorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

// Concrete Decorators
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    public double getCost() {
        return super.getCost() + 1.50;
    }
}

class MushroomDecorator extends PizzaDecorator {
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return super.getDescription() + ", Mushroom";
    }

    public double getCost() {
        return super.getCost() + 1.00;
    }
}

// Client code
public class DecoratorClient {
    /***
     * In this example, the Decorator pattern is used to add additional behavior and modify
     * the functionality of a Pizza object.
     *
     * The Pizza interface defines the common operations for a pizza, which are getDescription()
     * to get the description of the pizza and getCost() to get the cost of the pizza.
     *
     * The MargheritaPizza class is a concrete implementation of the Pizza interface,
     * representing a plain margherita pizza.
     *
     * The PizzaDecorator class is an abstract decorator that implements the Pizza interface and wraps a pizza object.
     * It provides default implementations for the common operations by delegating the calls
     * to the wrapped pizza object.
     *
     * The CheeseDecorator and MushroomDecorator classes are concrete decorators that extend the PizzaDecorator class.
     * They add cheese and mushroom toppings to the pizza, respectively. They override the getDescription()
     * and getCost() methods to append the topping description and add the topping cost to the original pizza.
     *
     * The client code creates an instance of a MargheritaPizza and then wraps it with CheeseDecorator
     * and MushroomDecorator to add toppings. It then calls getDescription() and getCost() on
     * the final decorated pizza to display the description and total cost.
     *
     * By using the Decorator pattern, we can dynamically add additional behaviors and modify
     * the functionality of an object at runtime without affecting other objects of the same class.
     * It provides a flexible and scalable way to extend the functionality of an object.
     * @param args
     */
    public static void main(String[] args) {
        Pizza margherita = new MargheritaPizza();
        margherita = new CheeseDecorator(margherita);
        margherita = new MushroomDecorator(margherita);

        System.out.println("Pizza Description: " + margherita.getDescription());
        System.out.println("Total Cost: $" + margherita.getCost());
    }
}
