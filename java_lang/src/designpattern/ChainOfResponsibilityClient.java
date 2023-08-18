package designpattern;

// Request class
class Request {
    private String type;
    private String content;

    public Request(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}

// Handler interface
interface Handler {
    public void setNextHandler(Handler nextHandler);
    public void handleRequest(Request request);
}

// Concrete Handlers
class EmailHandler implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (request.getType().equals("email")) {
            System.out.println("EmailHandler handles the request: " + request.getContent());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class SMSHandler implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (request.getType().equals("sms")) {
            System.out.println("SMSHandler handles the request: " + request.getContent());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class CallHandler implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (request.getType().equals("call")) {
            System.out.println("CallHandler handles the request: " + request.getContent());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Client code
public class ChainOfResponsibilityClient {
    /***
     * In this example, the Chain of Responsibility pattern is used to handle different types of requests (Request)
     * by a series of handlers (Handler).
     *
     * The Request class represents a request with a type and content.
     *
     * The Handler interface defines the contract for the handlers. It includes methods to set the next handler
     * in the chain (setNextHandler()) and to handle a request (handleRequest()).
     *
     * The EmailHandler, SMSHandler, and CallHandler are concrete implementations of the Handler interface.
     * Each handler checks the type of the request and handles it if it can, otherwise it passes the
     * request to the next handler in the chain if available.
     *
     * The client code creates instances of the handlers and sets the next handler in the chain.
     * Then, it creates different requests and passes them to the first handler in the chain.
     * The requests are handled by the appropriate handler or passed to the next handler until
     * the request is handled or the end of the chain is reached.
     *
     * By using the Chain of Responsibility pattern, we achieve a flexible
     * @param args
     */
    public static void main(String[] args) {
        Handler emailHandler = new EmailHandler();
        Handler smsHandler = new SMSHandler();
        Handler callHandler = new CallHandler();

        emailHandler.setNextHandler(smsHandler);
        smsHandler.setNextHandler(callHandler);

        Request request1 = new Request("email", "Send an email");
        emailHandler.handleRequest(request1);

        Request request2 = new Request("sms", "Send an SMS");
        emailHandler.handleRequest(request2);

        Request request3 = new Request("call", "Make a phone call");
        emailHandler.handleRequest(request3);

        Request request4 = new Request("notification", "Send a notification");
        emailHandler.handleRequest(request4);
    }
}
