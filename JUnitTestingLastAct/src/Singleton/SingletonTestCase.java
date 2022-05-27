package Singleton;


public class SingletonTestCase {

    public static boolean booleanMessage(String message) {
        return Singleton.Instance.newMessage().equals(message);
    }

    public static boolean allCreatedInstanceIsSame(Singleton singleton1, Singleton singleton2) {
        return singleton1.equals(singleton2);
    }

    public static Singleton objectExists() {
        Singleton singleton = Singleton.Instance;
        return singleton;
    }

    public static boolean isSame() {
        Singleton singleton1 = Singleton.Instance;
        Singleton singleton2 = Singleton.Instance;
        return singleton1.equals(singleton2);
    }

}
