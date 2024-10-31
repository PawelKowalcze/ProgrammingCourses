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

        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i+1)*(j+1);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
