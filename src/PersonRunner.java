import javax.swing.*;

public class PersonRunner
{
    public static void main(String[]args)
    {
        Student p1 = new Student("1234", "Oliver", "11/18/2004" , 11, 4.0);
        JOptionPane.showMessageDialog(null, p1.toString());
    }
}
