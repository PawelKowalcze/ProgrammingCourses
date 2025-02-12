package com.example.bankomat;

import java.util.Scanner;

public class Main {
    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        Bankomat  bankomat = new Bankomat("PKO BP", "Krakow", 200000.0);

        //tworzenie hard coded userów
        bankomat.addUser(new UserAdmin("janek",  bankomat), 1234);
        bankomat.addUser(new UserAdmin("pablo", bankomat), 4321);
        bankomat.addUser(new UserAdmin("sigma", bankomat), 1234);
        bankomat.addUser(new UserAdmin("skibidi", bankomat),1234);
        bankomat.addUser(new UserAdmin("rizler", bankomat),1234);
        bankomat.addUser(new UserAdmin("giat", bankomat),1234);

        //sesja działania programu
        while(true) {
            try{
                // Display menu options
                System.out.println("Type a number:");
                System.out.println("1. Sign in");
                System.out.println("2. Sign up");
                System.out.println("3. Transfer");
                System.out.println("9. Exit");

                // Get user input
                System.out.print("Your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("You chose to sign in.");
                        System.out.println("Enter login: ");
                        String login = scanner.nextLine();
                        System.out.print("Enter your PIN: ");
                        int pin = scanner.nextInt();
                        scanner.nextLine();

                        if(bankomat.zaloguj(login, pin)){
                            System.out.print("Logowanie udane");
                            while (true) {
                                System.out.println("\n\n");
                                System.out.println("User: " + bankomat.getCurrentUserLogin());
                                System.out.println("Saldo: "+bankomat.getUserSaldo());
                                System.out.println("\nType a number:");
                                System.out.println("1.make wpłata");
                                System.out.println("2.make wypłata");
                                System.out.println("9.logout");
                                int choice2 =scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();
                                Double kwota;

                                switch (choice2) {
                                    case 1:
                                        System.out.println("Podaj kwotę do wpłaty");
                                        kwota = scanner.nextDouble();
                                        scanner.nextLine();
                                        bankomat.makeWplata(kwota);
                                        break;
                                    case 2:
                                        System.out.println("Podaj kwotę do wypłaty");
                                        kwota = scanner.nextDouble();
                                        scanner.nextLine();
                                        bankomat.makeWyplata(kwota);
                                        break;

                                    case 3:
                                        System.out.println("You chose to transfer");
                                        System.out.println("Enter receiver login: ");
                                        String receiverLogin = scanner.nextLine();
                                        System.out.print("Enter amount to transfer: ");
                                        double amountToTransfer = scanner.nextDouble();
                                        scanner.nextLine();
                                        System.out.print("Enter your PIN to confirm: ");
                                        int transferPin = scanner.nextInt();
                                        scanner.nextLine();
                                        if (bankomat.transfer(receiverLogin, amountToTransfer, transferPin)) {
                                            System.out.println("Transfer successful.");
                                        } else {
                                            System.out.println("Transfer failed.");
                                        }
                                        break;

                                    case 9:
                                        System.out.println("wylogowywanie");
                                        bankomat.wyloguj();
                                        break;
                                }

                                // Exit the while loop if choice is 2
                                if (choice2 == 9) {
                                    break; // Exits the while loop
                                }
                            }
                        }else{
                            System.out.println("Złe dane logowania lub konto zablokowane");
                        }
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("You chose to sign up.");
                        System.out.println("Enter new login: ");
                        String newLogin = scanner.nextLine();
                        System.out.print("Enter your PIN: ");
                        int newPin = scanner.nextInt();
                        scanner.nextLine();
                        bankomat.addUser(new UserAdmin(newLogin,  bankomat), newPin);
                        break;


                    case 9:
                        System.out.println("Exiting...");
                        scanner.close();
                        return; // Exit the program
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            }catch(Exception e){
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

    }
}
