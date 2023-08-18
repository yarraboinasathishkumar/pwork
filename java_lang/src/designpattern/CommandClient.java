package designpattern;

// Command interface
interface Command {
    public void execute();
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light turned on");
    }

    public void turnOff() {
        System.out.println("Light turned off");
    }
}

// Concrete commands
class TurnOnCommand implements Command {
    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class CommandClient {
    /***
     * In this example, the Command pattern is used to encapsulate a request as an object and decouple
     * the sender of the request from the receiver.
     *
     * The Command interface declares the execute() method, which represents the action to be performed.
     *
     * The Light class is the receiver, which has methods to turn the light on and off.
     *
     * The TurnOnCommand and TurnOffCommand classes are concrete implementations of the Command interface.
     * They encapsulate the request to turn the light on and off, respectively.
     *
     * The RemoteControl class acts as the invoker, which is responsible for executing the commands.
     * It has a setCommand() method to set the command and a pressButton() method to execute the command.
     *
     * The client code creates instances of the receiver (Light) and the
     * concrete commands (TurnOnCommand and TurnOffCommand). It then sets the command in the remote control and
     * calls the pressButton() method to execute the command.
     *
     * By using the Command pattern, we achieve loose coupling between the sender and receiver of a request.
     * The sender (invoker) doesn't need to know the specifics of how the request is handled,
     * allowing for flexibility and extensibility in the system.
     * @param args
     */
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOnCommand = new TurnOnCommand(light);
        Command turnOffCommand = new TurnOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton(); // Output: Light turned on

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton(); // Output: Light turned off
    }
}
