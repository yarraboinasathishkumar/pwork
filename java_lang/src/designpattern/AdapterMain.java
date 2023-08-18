package designpattern;

// Adaptee interface
interface EuropeanSocketInterface {
    public int voltage();
    public int live();
    public int neutral();
    public int earth();
}

// Adaptee
class EuropeanSocket implements EuropeanSocketInterface {
    public int voltage() {
        return 230;
    }

    public int live() {
        return 1;
    }

    public int neutral() {
        return -1;
    }

    public int earth() {
        return 0;
    }
}

// Target interface
interface USASocketInterface {
    public int voltage();
    public int live();
    public int neutral();
}

// Adapter
class Adapter implements USASocketInterface {
    private EuropeanSocketInterface socket;

    public Adapter(EuropeanSocketInterface socket) {
        this.socket = socket;
    }

    public int voltage() {
        return 110;
    }

    public int live() {
        return socket.live();
    }

    public int neutral() {
        return socket.neutral();
    }
}

// Client
class ElectricKettle {
    private USASocketInterface socket;

    public ElectricKettle(USASocketInterface socket) {
        this.socket = socket;
    }

    public void boil() {
        if (socket.voltage() > 110) {
            System.out.println("Socket voltage too high - cannot boil");
        } else {
            System.out.println("Boiling water");
        }
    }
}

public class AdapterMain {
    /***
     * In this example, the EuropeanSocket class represents the Adaptee and the USASocketInterface
     * represents the Target interface. The Adapter class adapts the EuropeanSocketInterface
     * to the USASocketInterface, allowing the ElectricKettle client to work with the European socket.
     *
     * The ElectricKettle client can boil water using the boil() method,
     * which checks the voltage of the socket and prints a message depending on
     * whether the voltage is too high or not. The socket is passed to the ElectricKettle
     * constructor as an argument, and is wrapped in an adapter object that implements
     * the USASocketInterface using the methods of the EuropeanSocket.
     *
     * This way, the ElectricKettle client can work with the EuropeanSocket using
     * the USASocketInterface, without having to change its code or modify
     * the EuropeanSocket class. This is the essence of the Adapter pattern -
     * it allows incompatible interfaces to work together by creating
     * a wrapper object that adapts one interface to another.
     * @param args
     */
    public static void main(String[] args) {
        // Usage
        EuropeanSocketInterface socket = new EuropeanSocket();
        Adapter adapter = new Adapter(socket);
        USASocketInterface usaSocket = adapter;
        ElectricKettle kettle = new ElectricKettle(usaSocket);
        kettle.boil();
    }
}

