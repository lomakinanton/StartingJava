
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        try {
            test1();
            //test2();
        } catch (MyEx e) {
            System.out.println("!!!!!!!");
        }

    }

    public static void test1() {
        throw new MyEx();
    }
}
