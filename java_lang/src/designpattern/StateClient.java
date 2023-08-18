package designpattern;

// State interface
interface State {
    public void pressPlayButton(AudioPlayer player);
}

// Concrete states
class PlayingState implements State {
    public void pressPlayButton(AudioPlayer player) {
        player.changeState(new PausedState());
        System.out.println("Pause playing");
    }
}

class PausedState implements State {
    public void pressPlayButton(AudioPlayer player) {
        player.changeState(new PlayingState());
        System.out.println("Resume playing");
    }
}

// Context
class AudioPlayer {
    private State state;

    public AudioPlayer() {
        this.state = new PausedState();
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void pressPlayButton() {
        state.pressPlayButton(this);
    }
}

// Client code
public class StateClient {
    /***
     * In this example, the State interface defines the contract for the states of the AudioPlayer context.
     * The PlayingState and PausedState classes are the concrete states that implement the state-specific behavior.
     *
     * The AudioPlayer class is the context that contains a reference to the current state.
     * It has a changeState() method to allow changing the state and a pressPlayButton()
     * method that delegates the button press event to the current state object.
     *
     * The client code creates an AudioPlayer object and calls the pressPlayButton() method
     * to trigger the state-specific behavior. The AudioPlayer object's behavior changes depending on
     * the current state, and the state can be changed at runtime using the changeState() method.
     *
     * By using the State pattern, the client code can switch between different states of
     * the AudioPlayer object at runtime by simply calling the appropriate methods.
     * This allows for more flexibility and modularity in the code, and makes it
     * easier to add or change states without affecting the client code.
     * @param args
     */
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.pressPlayButton(); // Output: Resume playing
        player.pressPlayButton(); // Output: Pause playing
        player.pressPlayButton(); // Output: Resume playing
    }
}

