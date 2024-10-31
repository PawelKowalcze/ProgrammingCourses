import java.util.ArrayList;
import java.util.Scanner;

public class MultidimentionalArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> shoppingList = new ArrayList<>();

        ArrayList<String> bakeryList = new ArrayList<String>();
        bakeryList.add("pasta");
        bakeryList.add("bread");
        bakeryList.add("donuts");
        System.out.println(bakeryList);
        //System.out.println("Add another element to a list: ");
        //bakeryList.add(sc.nextLine());
        //System.out.println(bakeryList);

        ArrayList<String> produceList = new ArrayList<String>();
        produceList.add("tomatoes");
        produceList.add("zucchini");
        produceList.add("peppers");
        System.out.println(produceList);

        ArrayList<String> drinksList = new ArrayList<String>();
        drinksList.add("pepsi");
        drinksList.add("cola");
        System.out.println(drinksList);

        shoppingList.add(bakeryList);
        shoppingList.add(produceList);
        shoppingList.add(drinksList);
        System.out.println(shoppingList);
        System.out.println(shoppingList.get(0).get(2));
    }
}
