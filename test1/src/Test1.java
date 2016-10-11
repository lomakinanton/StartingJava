
import java.util.Scanner;

/*
 * @author Anton Lomakin
 */
public class Test1 {

    public static void main(String[] args) {
        int a;
        int b;
        int[] arr = new int[2];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a:");
        a = in.nextInt();
        System.out.println("Enter b:");
        b = in.nextInt();
        System.out.println(String.format("Sum=%s", a+b));
    }
}
