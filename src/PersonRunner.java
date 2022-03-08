import javax.swing.*;
import java.util.ArrayList;

public class PersonRunner
{
    public static void main(String[]args)
    {
        ArrayList<Person> people = new ArrayList<Person>();
        Person p1 = new Person("2345", "Mary", "05/20/1938");
        Student s1 = new Student("1234", "Oliver", "11/18/2004" , 11, 4.0);
        JOptionPane.showMessageDialog(null, p1);
        JOptionPane.showMessageDialog(null, s1);
        people.add(p1);
        people.add(s1);
        JOptionPane.showMessageDialog(null, people);
    }
}
