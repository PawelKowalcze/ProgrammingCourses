package com.example.bankomat;

public class UserAdmin {
   private String login;
   private int iloscTranzakcji;
   private Bankomat bankomat;


        //METODA WPLACANIE
      //TODO: 1 krok to w bankomacie trzeba sprawdzic czy jest miejsca na tyle pieniedzy, czyli jakas metoda sprawdzajaca w bankomacie
       //TODO: 2 krok to sprawdzenie w Banku czy zgadza się login z pinem takżę też trzeba jakąś metodę na to napisać
       //TODO: 3 krok to update salda w liscie userów
    //Myśle że ta metoda się powinna znaleść w bankproxy, i zrobimy w konstruktorze podanie obiektu bankomat i na nim się wywoła tą metodę:
    //bankomat.wplata(saldo, this.login, this.pin)
    //bo z bankomatu sie można dostać do metod bank proxy bo z niego dziedziczy
    //i tam się to całe sprawdzanie wykona a nie w klasie user bo to by było mało bezpieczne

    //tak samo wypłata, make przelew,




   //login getter
    public String getLogin(){
       return this.login;
    }



    //getery settery

    //konstruktor
    UserAdmin(String login, Bankomat bankomat){
        this.login = login;
        this.bankomat = bankomat;// o tym pisze w tym TODO
        iloscTranzakcji = 0;
    }
}
