import javax.swing.JOptionPane;

public class GUI {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name?"); // this method returns string
        JOptionPane.showMessageDialog(null, "Hello " + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); // we want to convert string into integer
        JOptionPane.showMessageDialog(null, "Your age is " + age);

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height")); // we want to convert string into integer
        JOptionPane.showMessageDialog(null, "Your are " + height + " cm tall.");
    }
}
