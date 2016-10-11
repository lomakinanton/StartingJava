
import java.util.Arrays;
import java.util.Scanner;

/*
 * @author Anton Lomakin
 * using sieve of Eratosthenes
 */
public class Test2 {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n:");
        n = in.nextInt();
        boolean[] ar = new boolean[n];
        Arrays.fill(ar, true);
        ar[0] = false;
        ar[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (ar[i]) {
                for (int j = i * i; j < n; j += i) {
                    ar[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (ar[i]) {
                System.out.println(i);
            }
        }
    }
}