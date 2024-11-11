public class Methods {
    static void hi(String name, int age) {
        System.out.println("HI "+ name);
        System.out.println("You are " + age + " years old.");
    }

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        String name = "Pawel";
        int age = 20;
        hi(name, age);

        int x = 19;
        int y = 50;

        System.out.println(add(x, y));
    }
}
