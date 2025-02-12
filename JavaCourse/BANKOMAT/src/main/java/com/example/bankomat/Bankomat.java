package com.example.bankomat;

import java.util.Map;

public class Bankomat extends BankProxy{
    private String location;
    private String currentUserLogin;
    private double balance;
    private double maxCapacity;


    public Boolean transfer(String receiverLogin, double amount, int pin) {
        if (currentUserLogin != null && amount > 0) {
            if (loginValidate(currentUserLogin, pin)) {
                UserAdmin sender = null;
                UserAdmin receiver = null;

                for (Map.Entry<UserAdmin, Double> entry : userSaldo.entrySet()) {
                    UserAdmin user = entry.getKey();

                    if (user.getLogin().equals(currentUserLogin)) {
                        sender = user;
                    } else if (user.getLogin().equals(receiverLogin)) {
                        receiver = user;
                    }

                    if (sender != null && receiver != null) {
                        break;
                    }
                }

                if (sender != null && receiver != null) {
                    double senderSaldo = userSaldo.get(sender);
                    if (senderSaldo >= amount) {
                        userSaldo.put(sender, senderSaldo - amount);
                        userSaldo.put(receiver, userSaldo.get(receiver) + amount);
                        return true;
                    }
                }
            } else {
                System.out.println("Invalid PIN.");
            }
        }
        return false;
    }


    //TODO 1 logowanie
    public boolean zaloguj(String login, int pin){
        if(!isUserBlocked(login)) {
            if (loginValidate(login, pin)) {
                this.currentUserLogin = login;
                return true; //zalogowano poprawnie
            } else {
                return false;
            }
        }
       return false;
    }

    public void wyloguj(){
        this.currentUserLogin = null;
    }



    //TODO 2 blokowanie bankomatu
    //TODO 3 wyciąganie pieniędzy,to hyba będzie jakoś połączone z metodą wypłata w bankproxy
    //TODO 4 zgłoś problem ? to nie wiem jak narazie xd
    //TODO 5 update pin
    // TODO LOGIN NIE MOZE SIE POWTARZAC PRZY DODAWANIU

    //wpłata TODO  log transaction na koncu
    public Boolean makeWplata(double kwota){
        System.out.println("makeWplata");
        System.out.println(this.balance);
        if(currentUserLogin != null && (this.balance + kwota) <= this.maxCapacity){
            System.out.println("currentUserLogin: " + currentUserLogin);
            for(Map.Entry<UserAdmin, Double> entry : userSaldo.entrySet()){
                UserAdmin user = entry.getKey();

                if (user.getLogin().equals(currentUserLogin)){
                    double currentSaldo = entry.getValue();
                    userSaldo.put(user, currentSaldo + kwota);
                    this.balance += kwota;
                    return true;
                }
            }
        }
        return false;
    }

    //wypłata
    public Boolean makeWyplata(double kwota) {
        System.out.println("makeWyplata");
        System.out.println(this.balance);
        if (currentUserLogin != null && kwota <= this.balance) {
            for (Map.Entry<UserAdmin, Double> entry : userSaldo.entrySet()) {
                UserAdmin user = entry.getKey();

                if (user.getLogin().equals(currentUserLogin)) {
                    double currentSaldo = entry.getValue();
                    if (currentSaldo >= kwota) {
                        userSaldo.put(user, currentSaldo - kwota);
                        this.balance -= kwota;
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public Boolean makeWplataAtm(double kwota){
        if(currentUserLogin.equals("admin") && (this.balance + kwota) <= this.maxCapacity){
           this.balance += kwota;
           return true;
        }
        return false;
    }

    public Boolean makeWyplataAtm(double kwota){
        if(currentUserLogin.equals("admin") && (this.balance - kwota) >= 0){
            this.balance -= kwota;
            return true;
        }
        return false;
    }
//get set
    public String getCurrentUserLogin(){
        return this.currentUserLogin;
    }

    public Double getUserSaldo() {
        if (currentUserLogin != null) {
            for (Map.Entry<UserAdmin, Double> entry : userSaldo.entrySet()) {
                UserAdmin user = entry.getKey();

                if (user.getLogin().equals(currentUserLogin)) {
                    return entry.getValue();
                }
            }
        }
        return -1.0;
    }

    public String getLocation(){
        return this.location;
    }

    public String getBank(){
        return this.bankName;
    }

    public double getBalance() {
        return balance;
    }

    //konstruktor
    public Bankomat(String nazwa, String location, double maxCapacity) {
        super(nazwa);
        this.location = location;
        this.maxCapacity = maxCapacity;//więcej niz 100 000
        this.balance = maxCapacity/2;
    }
}
