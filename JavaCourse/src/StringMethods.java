public class StringMethods {
    public static void main(String[] args) {
        String name = "Plawel";
        String emptyname = " ";
        String weirdname = "     cojones     ";
        boolean resultbool1 = name.equals("Pawel");
        boolean resultbool2 = name.equals("pawel");
        boolean resultbool3 = name.equalsIgnoreCase("pawel");
        System.out.println(resultbool1);
        System.out.println(resultbool2);
        System.out.println(resultbool3);

        int resultint4 = name.length();
        System.out.println(resultint4);

        char resultchar = name.charAt(2);
        System.out.println(resultchar);

        int resultint5 = name.indexOf("l"); //pierwszy pasujący
        System.out.println(resultint5);

        boolean resultboolean = emptyname.isEmpty();
        System.out.println(resultboolean);
        resultboolean = emptyname.isBlank();
        System.out.println(resultboolean);

        String resultstring = name.toUpperCase();
        System.out.println(resultstring);
        resultstring = name.toLowerCase();
        System.out.println(resultstring);

        System.out.println(weirdname);
        resultstring = weirdname.trim();
        System.out.println(resultstring);

        resultstring = weirdname.replace("o","H");
        System.out.println(resultstring);

    }
}
