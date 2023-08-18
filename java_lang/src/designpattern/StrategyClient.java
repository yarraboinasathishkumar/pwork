package designpattern;

// Context
class SortingContext {
    private SortingStrategy strategy;

    public SortingContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }
}

// Strategy interface
interface SortingStrategy {
    public void sort(int[] array);
}

// Concrete strategies
class BubbleSort implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using bubble sort");
        // Implementation of bubble sort
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] array) {
        System.out.println("Sorting using quick sort");
        // Implementation of quick sort
    }
}

// Client code
public class StrategyClient {
    /***
     * In this example, the SortingContext class is the context that contains a reference to a SortingStrategy object.
     * The SortingStrategy interface defines the strategy contract, and the BubbleSort and
     * QuickSort classes are the concrete strategy implementations.
     *
     * The client code creates a SortingContext object with a BubbleSort strategy,
     * and then calls the executeStrategy() method with an array to sort. Then,
     * the SortingContext object's strategy is set to QuickSort, and the executeStrategy()
     * method is called again to sort the same array using the new strategy.
     *
     * By using the Strategy pattern, the client code can switch between different strategies
     * at runtime by simply setting a new strategy on the SortingContext object.
     * This allows for more flexibility and modularity in the code, and makes it easier to
     * add or change strategies without affecting the client code.
     * @param args
     */
    public static void main(String[] args) {
        SortingContext context = new SortingContext(new BubbleSort());
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        context.executeStrategy(array);

        context.setStrategy(new QuickSort());
        context.executeStrategy(array);
    }
}
