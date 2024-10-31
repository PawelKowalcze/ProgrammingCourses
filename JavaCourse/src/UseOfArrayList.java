import java.util.ArrayList;

public class UseOfArrayList {
    public static void main(String[] args) {
        // ArrayList = a resizable array.
        // ArrayList<wrapperclasshere>

        ArrayList<String> food = new ArrayList<String>();

        food.add("Apple");
        food.add("Banana");
        food.add("Bread");

        food.set(0,"Pizza");
        food.remove(2);
        //food.clear();
        for (int i = 0; i < food.size(); i++) { // food.size() not .length()
            System.out.println(food.get(i));    // food.get(index) not food[index]
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        for (int i = 0; i < numbers.size(); i++) { // food.size() not .length()
            System.out.println(numbers.get(i));    // food.get(index) not food[index]
        }

        System.out.println(numbers);
    }
}
