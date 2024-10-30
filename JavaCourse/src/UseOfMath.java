import java.util.Scanner;

public class UseOfMath {
    static double hypotenuseOfTriangle(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static void main(String[] args) {
        double a = 25.7;
        double b = -2.0;
        double z = -53.0;

        double c = Math.max(a,b);
        System.out.println(c);

        c = Math.min(a,b);
        System.out.println(c);

        System.out.println(Math.abs(z));
        System.out.println(Math.sqrt(a));
        System.out.println(Math.ceil(a));
        System.out.println(Math.floor(a));

        double x = 0;
        double y = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X: ");
        x = scanner.nextDouble();
        System.out.println("Enter Y: ");
        y = scanner.nextDouble();


        System.out.println("Hypotenuse of a triangle is: " + hypotenuseOfTriangle(x,y));
        scanner.close();
    }
}
