package day7;

class ASingleton
{
    private static ASingleton instance;
    private ASingleton()
    {
        // private constructor
    }
    //synchronized method to control simultaneous access
    public synchronized  static ASingleton getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new ASingleton();
        }
        return instance;
    }
}
public class SingletonTest {
    // Singleton class
    public static void main(String[] s) {
        ASingleton test = ASingleton.getInstance();
        ASingleton test2 = ASingleton.getInstance();
        System.out.println(test);
        System.out.println(test2);
    }

}
