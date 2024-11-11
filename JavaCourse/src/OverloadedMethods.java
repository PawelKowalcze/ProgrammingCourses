public class OverloadedMethods {
    static int add(int a, int b) {
        System.out.println("1 method");
        return a + b;
    }
    static int add(int a, int b, int c) {
        System.out.println("2 method");
        return a + b + c;
    }

    static double add(double a, double b) {
        System.out.println("3 method");
        return a + b;
    }

    static double add(double a, double b, double c) {
        System.out.println("4 method");
        return a + b + c;
    }




    public static void main(String[] args) {
    double a = add(1.0,2.0, 4.0);
    System.out.println(a);

    }
}
