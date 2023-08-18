package designpattern;

import java.util.ArrayList;
import java.util.List;

// Iterator interface
interface Iterator<T> {
    public boolean hasNext();
    public T next();
}

// Aggregate interface
interface Aggregate<T> {
    public Iterator<T> createIterator();
}

// Concrete Iterator
class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private int position;

    public ListIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    public boolean hasNext() {
        return position < list.size();
    }

    public T next() {
        T element = list.get(position);
        position++;
        return element;
    }
}

// Concrete Aggregate
class ListAggregate<T> implements Aggregate<T> {
    private List<T> list;

    public ListAggregate() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public Iterator<T> createIterator() {
        return new ListIterator<>(list);
    }
}

// Client code
public class IteratorClient {
    /***
     * In this example, the Iterator pattern is used to provide a way to access elements of a collection without
     * exposing its underlying implementation.
     *
     * The Iterator interface declares the methods hasNext() and next() for iterating over a collection.
     *
     * The Aggregate interface declares the method createIterator() to create an iterator for the collection.
     *
     * The ListIterator class is a concrete iterator that implements the Iterator interface. It maintains a
     * reference to the list and a position to keep track of the current element being iterated.
     *
     * The ListAggregate class is a concrete aggregate that implements the Aggregate interface.
     * It represents a list and provides methods to add elements to the list and create an iterator for the list.
     *
     * The client code creates an instance of ListAggregate, adds elements to the list, and then creates an
     * iterator using the createIterator() method. It iterates over the collection using the
     * iterator and prints each element.
     *
     * By using the Iterator pattern, we can traverse elements of a collection without exposing its internal structure.
     * It provides a consistent way to access elements and allows for multiple iterations over the same collection
     * without interfering with each other.
     * @param args
     */
    public static void main(String[] args) {
        ListAggregate<String> aggregate = new ListAggregate<>();
        aggregate.add("Element 1");
        aggregate.add("Element 2");
        aggregate.add("Element 3");

        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
