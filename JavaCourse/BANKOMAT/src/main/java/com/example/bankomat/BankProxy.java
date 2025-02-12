package com.example.bankomat;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class BankProxy {
    protected String bankName;
    private Map<UserAdmin, Boolean> userList;//tutaj dałem boolean jako status, czy konto jest zablokowane czy nie, jeśli zablokowany to true
    private Map<UserAdmin, Integer> userPin;//tutaj przechowujemy piny userów
    protected Map<UserAdmin, Double> userSaldo;
    private String[][] transactionList;   //tutaj dodajmy to w takiej kolejności dla prostszego poruszania się potem: login ; jaka operacja(wplata, przelew...), adresat ;
    protected void updatePIN(String login){

    }
    //2 metoda get user history
    protected void downloadTransactionHistory() {
        String userHome = System.getProperty("user.home");
        String dest = userHome + "/Downloads/transaction_history.pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Transaction History"));

            for (String[] transaction : transactionList) {
                if(transaction[0] != null) {
                    String transactionDetails = String.join(", ", transaction);
                    document.add(new Paragraph(transactionDetails));
                }
            }

            document.close();
            System.out.println("Transaction history PDF created successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void downloadUserTransactionHistory(String login) {
        String userHome = System.getProperty("user.home");
        String dest = userHome + "/Downloads/" + login + "_transaction_history.pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Transaction History for " + login));

            for (String[] transaction : transactionList) {
                if (transaction[0] != null && (transaction[0].equals(login) || transaction[2].equals(login))) {
                    String transactionDetails = String.join(", ", transaction);
                    document.add(new Paragraph(transactionDetails));
                }
            }

            document.close();
            System.out.println("Transaction history PDF for " + login + " created successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //3 metoda block account
    protected void blockAccount(String login) {
        for (Map.Entry<UserAdmin, Boolean> entry : userList.entrySet()) {
            UserAdmin user = entry.getKey();

            if (user.getLogin().equals(login)) {
                userList.put(user, true); // Update the status to 'blocked'
            }
        }
    }

    //log transaction
    protected void logTransaction(String login, String operation, String adresat, double kwota) {
            String[][] newTransactionList = new String[transactionList.length + 1][];

            for (int i = 0; i < transactionList.length; i++) {
                newTransactionList[i] = transactionList[i];
            }

            newTransactionList[transactionList.length] = new String[]{login, operation, adresat, Double.toString(kwota)};

            transactionList = newTransactionList;
        }

//gettery i settery

    public String getLastTransaction() {
        if (transactionList.length == 0) {
            return null; // No transactions available
        }
        String[] lastTransaction = transactionList[transactionList.length - 1];
        return String.join(", ", lastTransaction);
    }

   //sprawdzanie czy podał dobry pin i login
   protected boolean loginValidate(String login, int pin) {
       if (userPin == null) {
           throw new IllegalStateException("User PIN map is not initialized.");
       }

       for (Map.Entry<UserAdmin, Integer> entry : userPin.entrySet()) {
           UserAdmin user = entry.getKey();
           int storedPin = entry.getValue();

           // Check if the login matches and the pin is correct
           if (user.getLogin().equals(login) && storedPin == pin) {
               return true; // Successful login
           }
       }

       return false; // Invalid login or pin
   }

   //sprawdzanie czy user jest zablokowany
    protected boolean isUserBlocked(String login) {
        if (userList == null) {
            throw new IllegalStateException("User list map is not initialized.");
        }

        for (Map.Entry<UserAdmin, Boolean> entry : userList.entrySet()) {
            UserAdmin user = entry.getKey();
            boolean isBlocked = entry.getValue();

            // Check if the login matches and return the blocked status
            if (user.getLogin().equals(login)) {
                return isBlocked;
            }
        }

        return false;
    }

    protected boolean loginExist(String login){
        for (Map.Entry<UserAdmin, Boolean> entry : userList.entrySet()) {
            UserAdmin user = entry.getKey();

            if (user.getLogin().equals(login)) {
                return true;
            }
        }

        return false;
    }


    //odawanie utworzonego usera do listy userów
    // TODO  zabezpieczenia na to
    protected void addUser(UserAdmin user, int pin){
        this.userList.put(user, false);
        this.userPin.put(user, pin);
        this.userSaldo.put(user, 0.0);
    }

    protected double getBalance(String login) {
        return userSaldo.get(login);
    }

    protected String getBankName() {
        return bankName;
    }

    //zmiana pinu

    protected boolean changePin(String login, int newPin, int oldPin) {
        for (Map.Entry<UserAdmin, Integer> entry : userPin.entrySet()) {
            UserAdmin user = entry.getKey();
            System.out.println(entry.getValue());

            if (user.getLogin().equals(login) && entry.getValue() == oldPin) {
                userPin.put(user, newPin);
                return true;
            } else {
                System.out.println("Invalid login or pin.");
                return false;
            }
        }
        return false;
    }

//KONSTRUKTORY
    public BankProxy(String nazwa){
        this.bankName = nazwa;
        userList = new HashMap<>();
        userSaldo = new HashMap<>();
        userPin = new HashMap<>();
        transactionList = new String[1][1];

    }



}
