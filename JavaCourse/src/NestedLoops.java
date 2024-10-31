import java.util.Scanner;

public class NestedLoops {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows;
        int cols;
        String symbol = "";

        System.out.println("Enter the number of rows: ");
        rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        cols = sc.nextInt();
        System.out.println("Enter the symbol: ");
        symbol = sc.next();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }

    }
}
