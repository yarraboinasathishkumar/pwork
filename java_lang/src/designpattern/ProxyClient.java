package designpattern;

// Subject interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyClient {
    public static void main(String[] args) {
        /***
         * In this example, the Proxy design pattern is used to control access to an object by providing a surrogate
         * or placeholder for it.
         *
         * The Image interface represents the subject, which defines the common operations for displaying an image.
         *
         * The RealImage class is the real subject, which implements the Image interface. It loads an image from
         * disk and displays it.
         *
         * The ProxyImage class is the proxy, which also implements the Image interface. It maintains a reference
         * to the real subject (RealImage). The first time display() is called, it creates an instance of RealImage
         * and calls its display() method. On subsequent calls, it directly calls the display() method of the
         * real subject without loading the image again.
         *
         * The client code demonstrates the usage of the Proxy pattern. It creates instances of the proxy (ProxyImage)
         * and calls the display() method on them. The first time the display() method is called, it loads and
         * displays the image. On subsequent calls, it directly displays the image without loading it again.
         *
         * By using the Proxy pattern, we can control access to an object and add additional functionality to it,
         * such as lazy loading, caching, or security checks, without modifying the original object.
         * It provides a level of indirection and can improve the performance and efficiency of the system.
         */
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is loaded and displayed when calling display()
        image1.display(); // Output: Loading image from disk: image1.jpg
        //         Displaying image: image1.jpg

        // Image is already loaded, no disk loading occurs
        image1.display(); // Output: Displaying image: image1.jpg

        // Image is loaded and displayed when calling display()
        image2.display(); // Output: Loading image from disk: image2.jpg
        //         Displaying image: image2.jpg

    }
}
