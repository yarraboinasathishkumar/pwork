package designpattern;

// Subsystem classes
class CPU {
    public void freeze() { /* ... */ }
    public void jump(long position) { /* ... */ }
    public void execute() { /* ... */ }
}

class Memory {
    public void load(long position, byte[] data) { /* ... */ }
}

class HardDrive {
    public byte[] read(long lba, int size) { /* ... */
    return null;}
}

// Facade
class ComputerFacade {
    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(0, hd.read(0, 1024));
        processor.jump(0);
        processor.execute();
    }
}

// Client code
public class FacadeClient {
    /***
     * In this example, the CPU, Memory, and HardDrive classes represent the subsystem classes that provide low-level
     * functionality. The ComputerFacade class is the facade that provides a simplified interface to
     * these subsystems, making it easier to use the computer.
     *
     * The ComputerFacade constructor initializes the subsystem objects and the start() method starts the
     * computer by calling the appropriate methods on the subsystems in the correct order.
     *
     * The Client class is the user of the facade and creates an instance of the ComputerFacade class to
     * start the computer.
     *
     * By using the Facade pattern, the client code can interact with a simplified interface, provided by the
     * ComputerFacade, instead of directly interacting with the complex subsystems.
     * This simplifies the client code and makes it less error-prone, while still allowing
     * access to the full functionality of the subsystems.
     * @param args
     */
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}

