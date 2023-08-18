package designpattern;

// Product class
class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "House with " +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", interior='" + interior + '\'';
    }
}

// Abstract Builder
interface HouseBuilder {
    public void buildFoundation();
    public void buildStructure();
    public void buildRoof();
    public void buildInterior();
    public House getHouse();
}

// Concrete Builder
class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    public void buildFoundation() {
        house.setFoundation("Concrete");
    }

    public void buildStructure() {
        house.setStructure("Brick and Concrete");
    }

    public void buildRoof() {
        house.setRoof("Tiles");
    }

    public void buildInterior() {
        house.setInterior("Wooden and Marble");
    }

    public House getHouse() {
        return house;
    }
}

// Director
class CivilEngineer {
    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        houseBuilder.buildInterior();
        return houseBuilder.getHouse();
    }
}

// Client code
public class BuilderClient {
    /***
     * In this example, the Builder pattern is used to construct a complex object (House) step by step.
     *
     * The House class represents the product that we want to build. It has various attributes such as foundation,
     * structure, roof, and interior.
     *
     * The HouseBuilder interface defines the steps required to build a house. It includes methods for building
     * the foundation, structure, roof, and interior, as well as a method to get the final constructed house.
     *
     * The ConcreteHouseBuilder class is a concrete implementation of the HouseBuilder interface.
     * It builds a specific type of house using the step-by-step building process defined by the interface.
     *
     * The CivilEngineer class acts as a director and is responsible for using the builder to
     * construct the house. It provides a constructHouse() method that follows a specific sequence of
     * building steps and returns the final constructed house.
     *
     * The client code creates an instance of the ConcreteHouseBuilder and passes it to the CivilEngineer.
     * The CivilEngineer then constructs the house by calling the appropriate methods on the builder.
     * Finally, the constructed house is retrieved and printed.
     *
     * By using the Builder pattern, we can separate the construction logic from the complex
     * object's representation, allowing us to create different variations of the object with the same building process.
     * It provides a clean and flexible way to construct objects, especially when dealing with objects with
     * many optional parameters or complex initialization steps.
     * @param args
     */
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        CivilEngineer engineer = new CivilEngineer(builder);
        House house = engineer.constructHouse();
        System.out.println(house);
    }
}
