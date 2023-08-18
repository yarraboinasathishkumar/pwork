package designpattern;

import java.util.ArrayList;
import java.util.List;

// Memento
class EditorMemento {
    private String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator
class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }
}

// Caretaker
class History {
    private List<EditorMemento> mementos;

    public History() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(EditorMemento memento) {
        mementos.add(memento);
    }

    public EditorMemento getMemento(int index) {
        return mementos.get(index);
    }
}

// Client code
public class MementoClient {
    /***
     * In this example, the Memento design pattern is used to save and restore the state of an Editor object.
     *
     * The EditorMemento class represents the memento and stores the state of the Editor. It has a getContent()
     * method to retrieve the saved content.
     *
     * The Editor class is the originator and has methods to set and get the content.
     * It also has save() and restore() methods that create a memento and restore the state from a memento, respectively.
     *
     * The History class acts as the caretaker and keeps track of the mementos.
     * It has methods to add mementos to the history and retrieve a memento at a specific index.
     *
     * The client code demonstrates the usage of the Memento pattern. It creates an instance of
     * the Editor and History. It sets the content of the editor, creates a memento, and adds it to the history.
     * It repeats this process for multiple content changes. Then, it demonstrates restoring the editor's
     * content to previous states by retrieving mementos from the history.
     *
     * By using the Memento pattern, we can capture and restore the state of an object without exposing
     * its internal structure. It provides the ability to rollback or undo changes and can be useful in
     * scenarios where maintaining the history of state changes is required.
     * @param args
     */
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("This is the initial content.");
        history.addMemento(editor.save());

        editor.setContent("Modified content.");
        history.addMemento(editor.save());

        editor.setContent("More changes made.");
        history.addMemento(editor.save());

        System.out.println("Current content: " + editor.getContent());

        // Restore to previous state
        editor.restore(history.getMemento(1));
        System.out.println("Restored content: " + editor.getContent());

        // Restore to initial state
        editor.restore(history.getMemento(0));
        System.out.println("Restored content: " + editor.getContent());
    }
}
