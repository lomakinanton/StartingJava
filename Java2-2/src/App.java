
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anton
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            test7;
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void test() {
        int a = 1;
        int b = 0;

        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Arithm");
        } catch (RuntimeException e) {
            System.out.println("Runtime");
        } catch (Exception e) {
            System.out.println("Exception");
        } catch (Throwable e) {
            System.out.println("Throwable");
        }
    }

    public static void test2(int b) {
        int a = 1;

        try {
            int x = a / b;
        } catch (Throwable e) {
            System.out.println("Throwable");
        } finally {
            System.out.println("Finnaly");
        }
        System.out.println("Finish");

    }

    public static void test5(String s) {
        if (s == null || s.length() == 0) {
            throw new RuntimeException("RuntimeException empty string");
        }
    }

    public static void test6(String s) throws Exception {
        if (s == null || s.length() == 0) {
            throw new Exception("Exception empty string");
        }
    }

    public static void test7() {
        int a = 1;
        int b = 0;

        try {
            System.out.println(a / b);
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Arithm");
        }

    }
}
