import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";

        while (name.isBlank()) {
            System.out.print("Enter your name: ");
            name = sc.nextLine();
        }
        System.out.println("Your name is " + name);

        // zawsze wykona się chociaż jeden raz
        do {
            System.out.print("Enter your name: ");
            name = sc.nextLine();
        } while (name.isBlank());
        System.out.println("Your name is " + name);
    }
}
