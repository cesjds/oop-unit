import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PersonRunner
{
    public static void main(String[]args)
    {
        ArrayList<Person> people = new ArrayList<Person>();
        Person p1 = new Person("2345", "Mary", "05/20/1938");
        Student s1 = new Student("1234", "Oliver", "11/18/2004" , 11, 4.0);
        Teacher t1 = new Teacher("3456", "Ms. Steelman", "03/06/1970", 400000);
        //JOptionPane.showMessageDialog(null, p1);
        //JOptionPane.showMessageDialog(null, s1);
        people.add(p1);
        people.add(s1);
        people.add(t1);

        people.add(new Student("99999", "Moshe", "04/07/2006", 10, 4.0));
        people.add(new Person("1111", "Izzy", "08/15/2022"));
        people.add(new Teacher("5555", "Ms. Ball", "09/12/1975", 506309.7));

        JOptionPane.showMessageDialog(null, people);

        Collections.sort(people);

        JOptionPane.showMessageDialog(null, people);
    }
}
