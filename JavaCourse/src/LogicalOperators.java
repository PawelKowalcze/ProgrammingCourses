import java.util.Scanner;

public class LogicalOperators {
    public static void main(String[] args) {
        // && = i
        // || = lub
        // ! = nie
        Scanner sc = new Scanner(System.in);
        System.out.println("Press q or Q to exit");
        String input = sc.next();

        if (input.equals("q") || input.equals("Q")) {
            System.out.println("You quit");
        }

    }
}
