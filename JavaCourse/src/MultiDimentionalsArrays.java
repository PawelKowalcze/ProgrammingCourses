import java.util.Arrays;

public class MultiDimentionalsArrays {
    public static void main(String[] args) {

        String[][] cars = {
                                {"Camaro","Mustang","Corvette"},
                                {"Tesla","T4","Opel"},
                                {"Mazda","Porsche","Ferrari"}
                            };

        System.out.println(Arrays.toString(cars[1]));

        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars[i].length; j++) {
                System.out.print(cars[i][j] + " ");

            }
            System.out.println();
        }
    }
}
