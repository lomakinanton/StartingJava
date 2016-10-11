
import java.util.Scanner;
/*
 * Anton Lomakin
 */
public class Equation {

    public static void main(String[] args) {
        double a, b, c, discriminant, x1, x2;
        System.out.println("ax^2 + bx + c = 0");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a:");
        a = in.nextDouble();
        System.out.println("Enter b:");
        b = in.nextDouble();
        System.out.println("Enter c:");
        c = in.nextDouble();
        
        if (a==0){
            x1=-c/b;
            System.out.println(String.format("x=%s", x1));
            return;
        }
       
        discriminant = b * b - 4 * a * c;

        if (discriminant > 0) { //2 корня
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            System.out.println(String.format("x1=%s, x2=%s", x1, x2));
        } else if (discriminant == 0) { //один корень
            x1 = -b / (2 * a);
            System.out.println(String.format("x=%s", x1));
        } else {
            System.err.println("The equation has no solutions"); //нет корней
        }
    }
}
