import java.util.Scanner;

public class UseOfIfElse {
    public static void main(String[] args) {
        int age = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        if (age > 18) {
            System.out.println("You are older than 18");
        }
        else if (age < 18) {
            System.out.println("You are not older than 18");
        }
        else {
            System.out.println("You are 18");
        }


    }
}
