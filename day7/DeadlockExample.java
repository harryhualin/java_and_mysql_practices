package day7;
class Key{
    private boolean available;
    Key(){
        this.available = true;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
public class DeadlockExample {
    public static void main(String[] args) {
        Key key1 = new Key();
        Key key2 = new Key();
        Thread Jason = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (key1) {
                key1.setAvailable(false);
                System.out.println("fan has key1");

                synchronized (key2) {
                    key2.setAvailable(false);
                    System.out.println("fan has key2");
                }
            }
        });
        Thread Joey = new Thread(() -> {
            synchronized (key2) {
                key2.setAvailable(false);
                System.out.println("landon has key2");
                synchronized (key1) {
                    key1.setAvailable(false);
                    System.out.println("landon has key1");
                }
            }
        });
        Jason.start();
        Joey.start();
    }
}