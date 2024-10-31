import java.util.Arrays;

public class UseofArrays {
    public static void main(String[] args) {
        String[] cars = {"Ferrari", "BMW", "Audi", "Mazda", "Sedan"};
        System.out.println(Arrays.toString(cars));
        System.out.println(cars[1]);

        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
