package designpattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name + " received an update!");
    }
}

public class ObserverMain {
    /***
     * In this example, Observer is an interface that defines the update method that will be called
     * when the subject's state changes. Subject is the object being observed, and it maintains
     * a list of observers that have subscribed to it. When the state of the subject changes,
     * it calls the update method on each observer in its list. ConcreteObserver is an implementation
     * of the Observer interface that simply prints a message when it receives an update.
     *
     * In the Main class, we create a Subject object and two ConcreteObserver objects. We then add both
     * observers to the subject's list of observers and call notifyObservers to trigger an update.
     * We then remove observer2 from the list and call notifyObservers again to see
     * that only observer1 receives the update.
     * @param args
     */
    public static void main(String[] args) {
        Subject subject = new Subject();

        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers();

        subject.removeObserver(observer2);

        subject.notifyObservers();
    }
}

