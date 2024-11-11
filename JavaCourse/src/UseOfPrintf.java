public class UseOfPrintf {
    public static void main(String[] args) {
        boolean myBoolean = true;
        char myChar = 'a';
        String myString = "Hello World";
        int myInt = 40;
        double myDouble = 40000.6;
        double myD = -40.6;
        //[conversion character]
        System.out.printf("%d Hello World \n", myInt); //d - decimal number,
        System.out.printf("%b Hello World \n", myBoolean);
        System.out.printf("%c Hello World \n", myChar);
        System.out.printf("%s Hello World \n", myString);
        System.out.printf("%f Hello World \n", myDouble);


        //[width]
        System.out.printf("%20s Hello World \n", myString);
        //[precision]
        System.out.printf("%.3f Hello World \n", myDouble);
        //[flags]
        // - : left justified
        // + : sign of a number
        // 0 : values are zero-padded
        // , : comma grouping separator
        System.out.printf("%40f Hello World \n", myDouble);
        System.out.printf("%-40f Hello World \n", myDouble);
        System.out.printf("%+f Hello World \n", myDouble);
        System.out.printf("%+f Hello World \n", myD);

        System.out.printf("%020f Hello World \n", myDouble);
        System.out.printf("%,f Hello World \n", myDouble);




    }
}
