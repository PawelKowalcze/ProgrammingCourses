import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("\"Hello world!\"");
        System.out.print("\\HI \n");
        System.out.println("\t What's up");
        int x = 10;
        System.out.print("Hi " + x);
        char symbol = 'a';
        System.out.println("Hi " + symbol);
        String name = "Pawel";
        System.out.println("Hi " + name);

        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name");
        String names = scanner.nextLine();
        System.out.println("Hi " + names);
        System.out.println("What's your age");
        int age = scanner.nextInt();
        scanner.nextLine(); // this clears scanner form \n so that i can use scanner.nextLine further on
        System.out.println("You are " + age + " years old");
        System.out.println("What do you do?");
        names = scanner.nextLine();
        System.out.println("You like " + names);


        float var = 10;
        System.out.println(var);
        var =  var / 4;
        System.out.println(var);
    }
}