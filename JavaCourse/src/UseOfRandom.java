import java.util.Random;


public class UseOfRandom {
    public static void main(String[] args) {

        Random rand = new Random();
        int x = rand.nextInt(100); // this starts form 0, our range is [0,99]
        int y = rand.nextInt(6) + 1; // now our  range is [1.6]
        System.out.println(x);
        System.out.println(y);
        double z = rand.nextDouble(); // random double between 0 and 1
        System.out.println(z);
        boolean a = rand.nextBoolean();
        System.out.println(a);
    }

}
