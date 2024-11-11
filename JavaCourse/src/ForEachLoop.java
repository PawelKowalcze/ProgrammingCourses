import java.util.ArrayList;

public class ForEachLoop {
    public static void main(String[] args) {
        String[] animals = {"cat","dog","rat","bird"};

        for (String i : animals){
            System.out.println(i);
        }

        int[] tab = {1,4,5,6,8};

        for (int j : tab){
            System.out.println(j);
        }

        ArrayList<String> animal = new ArrayList<String>();
        animal.add("cat");
        animal.add("dog");
        animal.add("rat");
        animal.add("bird");

        for (String i : animal){
            System.out.println(i);
        }
    }
}
