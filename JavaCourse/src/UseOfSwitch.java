import java.util.Scanner;

public class UseOfSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();

        switch (day) {  // i can use string, bool, int, double, char, and so on
            case "Monday":
                System.out.println("Today is " + day);
            break;
            case "Tuesday":
                System.out.println("Today is " + day);
                break;
            case "Wednesday":
                System.out.println("Today is " + day);
                break;
            case "Thursday":
                System.out.println("Today is " + day);
                break;
            case "Friday":
                System.out.println("Today is " + day);
                break;
            case "Saturday":
                System.out.println("Today is " + day);
                break;
            case "Sunday":
                System.out.println("Today is " + day);
                break;
            default:
                System.out.println(day + " is not a valid day");
            break;




        }

    }
}
