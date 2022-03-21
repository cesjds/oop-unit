import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/********************************************************************
 * Written by: Yoav Amit
 *
 * ASSIGNMENT:  Write a program that reads the data from states.txt
 * into an ArrayList of States. Then modify the print method I've provided,
 * your toString method and the formatting notes in Schoology to print
 * your database
 * Use the answer key I've attached to this assignment.
 *
 * The data in states.txt is in the following order:
 *		state name
 *      state capital
 *		state flower
 *		state bird
 *		state population (I think in 10 thousands)
 *
 * HAND IN:  Let me see your database print on your monitor.
 *
 *******************************************************************/

public class StateDB
{
    public static void print(ArrayList<State> states)
    {
        JTextArea area = new JTextArea();
        //append column headings here
        int spaces[] = new int[]{22, 18, 30, 30};

        String name = "NAME", capital = "CAPITAL", flower = "FLOWER", bird = "BIRD", pop = "POPULATION";
        for (State s: states) {
            //use the formatting notes and the area.append() method
            //to add each states name, capital, flower, bird and population.
        }

        area.setBackground(new Color(255,250,205));
        area.setForeground(new Color(0,0,0));
        area.setFont(new Font("Consolas", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null,pane);
    }
}