package state;

// Yoav Amit

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

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
    public static void main(String[] args)
    {
        String states[][] = new String[51][5];
        fillArray(states);
        printArray(states);

        //state.State s1 = new state.State(sn,sc,sf,sb,sp);
    }

    public static String[][] fillArray(String[][] states) {
        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));
            while (inFile.hasNext()) {
                for (int r = 0; r < 51; r++)
                {
                    for (int c = 0; c < 5; c++)
                    {
                        states[r][c] = inFile.nextLine();
                    }
                }
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return states;
    }
    public static void printArray(String[][] states) {
        JTextArea area = new JTextArea();
        //append column headings here
        String name = ""; String capital = ""; String flower = ""; String bird = ""; int pop = 0;
        for (String[] s : states) {
            //use the formatting notes and the area.append() method
            //to add each states name, capital, flower, bird and population.
        }

        area.setBackground(new Color(255,250,205));
        area.setForeground(new Color(0,0,0));
        area.setFont(new Font("Andale Mono", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);

        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, pane);
    }
}