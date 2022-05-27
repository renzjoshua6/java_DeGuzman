package Singleton;

public class Singleton {

    //create an object of SingleObject
    public static final Singleton Instance;

    public final String newMessage () {
        return "This is a Singleton";
    }
    //make the constructor private so that this class cannot be //instantiated
    // Exists only to defeat instantiation.
    private Singleton() {
    }

    static {
        Singleton newInstance = new Singleton();
       Instance = newInstance;
    }
}
