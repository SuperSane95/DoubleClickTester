/**
 * Created by iwano on 4/28/2016.
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           DoubleClickTester dct = new DoubleClickTester();
        });
        thread.start();
    }
}
