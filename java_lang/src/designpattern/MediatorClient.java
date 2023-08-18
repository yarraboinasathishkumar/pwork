package designpattern;

import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    public void sendMessage(String message, User user);
    public void addUser(User user);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receiveMessage(String message);
}

// Concrete Colleague
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " receives: " + message);
    }
}

// Client code
public class MediatorClient {
    public static void main(String[] args) {
        /***
         * In this example, the Mediator design pattern is used to enable communication between multiple users (User)
         * through a chat room (ChatRoom) without directly referring to each other.
         *
         * The ChatMediator interface defines the methods sendMessage() and addUser() to send messages and
         * add users to the chat room.
         *
         * The ChatRoom class is a concrete mediator that implements the ChatMediator interface.
         * It maintains a list of users and forwards messages from one user to the others.
         *
         * The User class is an abstract colleague that defines the common behavior for users.
         * It has a reference to the mediator and a name.
         *
         * The ChatUser class is a concrete colleague that extends the User class.
         * It implements the send() method to send messages to the mediator, and the receiveMessage()
         * method to receive messages from the mediator.
         *
         * The client code creates instances of the chat mediator (ChatRoom) and users (ChatUser).
         * It adds the users to the chat room and demonstrates communication between
         * the users by sending and receiving messages.
         *
         * By using the Mediator pattern, we can achieve loose coupling between users and enable communication
         * through a central mediator object. It promotes the principle of "delegation rather than
         * coordination" and allows for more flexible and decoupled communication between objects.
         */
        ChatMediator chatMediator = new ChatRoom();

        User user1 = new ChatUser(chatMediator, "User1");
        User user2 = new ChatUser(chatMediator, "User2");
        User user3 = new ChatUser(chatMediator, "User3");

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user1.send("Hello everyone!"); // Output: User1 sends: Hello everyone!
        //         User2 receives: Hello everyone!
        //         User3 receives: Hello everyone!

        user2.send("Hi User1!");       // Output: User2 sends: Hi User1!
        //         User1 receives: Hi User1!
        //         User3 receives: Hi User1!
    }
}
