package designpattern;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface Employee {
    public void showDetails();
}

// Leaf component
class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void showDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}

// Composite component
class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates;

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
        this.subordinates = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee) {
        subordinates.remove(employee);
    }

    public void showDetails() {
        System.out.println("Manager: " + name + ", Position: " + position);
        System.out.println("Subordinates:");
        for (Employee employee : subordinates) {
            employee.showDetails();
        }
    }
}

// Client code
public class CompositeClient {
    /***
     * In this example, the Composite design pattern is used to create a hierarchical structure of employees.
     *
     * The Employee interface defines the common operations that both leaf and composite components should implement.
     * In this case, it's the showDetails() method to display employee details.
     *
     * The Developer class is a leaf component that represents an individual employee.
     *
     * The Manager class is a composite component that represents a manager and can have subordinates,
     * which can be either individual developers or other managers. It maintains a list of subordinates and
     * implements the showDetails() method to display manager details and
     * recursively call showDetails() on its subordinates.
     *
     * The client code creates instances of developers (Developer) and managers (Manager) and
     * adds them to the appropriate composite components. It then calls the showDetails() method on
     * the top-level manager, which displays the details of the entire hierarchy.
     *
     * By using the Composite pattern, we can treat individual employees and groups of employees uniformly.
     * It allows us to build a tree-like structure of objects, making it easier to work with complex
     * hierarchies and treat leaf and composite components uniformly.
     * @param args
     */
    public static void main(String[] args) {
        Employee dev1 = new Developer("John Doe", "Senior Developer");
        Employee dev2 = new Developer("Jane Smith", "Junior Developer");

        Manager manager1 = new Manager("Mike Johnson", "Development Manager");
        manager1.addEmployee(dev1);
        manager1.addEmployee(dev2);

        Employee dev3 = new Developer("Bob Williams", "Senior Developer");
        Employee dev4 = new Developer("Alice Brown", "Junior Developer");

        Manager manager2 = new Manager("Karen Davis", "Project Manager");
        manager2.addEmployee(dev3);
        manager2.addEmployee(dev4);
        manager2.addEmployee(manager1);

        manager2.showDetails();
    }
}
