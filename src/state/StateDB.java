package state;

// Yoav Amit

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
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
 *
 * ASSIGNMENT: Write a program that writes a new State database program
 * 	using OOP and your State class.
 *
 * Your program should have a menu method that gives the user the following options:
 * 	print, search, add, delete, exit
 *
 * print should print the entire database in the text area we used in your orignial program.
 * search should ask for the name of a state and search for it. If it is found the
 *   information for that state should be printed using the toString() from State.
 * add should ask for the name of the state to be added. If that state is already in the
 *   database you should print a message saying it is already there. Otherwise ask for
 *   the rest of the information and add the state. You database should remain sorted
 *   by state name.
 * delete should ask for the name of the state to be deleted. If the state is in the database
 *   it should be deleted.
 * The user should be able to continue to run your program until they chooses to exit.
 *
 * NOTES:
 * You cannot use 51 as the size of the ArrayList since it will be changing.
 * You can create a dummy state using the name the user inputs, 4 empty Strings and 0.
 * This will be useful in search() & add() although there are other ways to write these
 * two methods.
 * You MUST use this for delete() - most of the delete method can be written using
 * methods from the ArrayList class.
 * You shouldn't print the entire database after add and delete. Your program should
 * go back to the main menu and the user can choose print from there.
 * Your program should be running from your main method but all that should be there
 * is declaring variables, a loop to keep the program going and method calls.
 *
 * HAND IN: after THOROUGHLY testing your program, copy and paste your code to
 * Schoology and submit.
 ********************************************************************/



public class StateDB
{
    public static void main(String[] args)
    {
        ArrayList states = new ArrayList<State>();
        fillArray(states);
        printArray(states);

        //state.State s1 = new state.State(sn,sc,sf,sb,sp);
    }

    public static ArrayList<State> fillArray(ArrayList<State> states)
    {
        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));
            while (inFile.hasNext()) {
                for (int r = 0; r < 51; r++)
                {
                    State s1 = new State(inFile.nextLine(), inFile.nextLine(), inFile.nextLine(), inFile.nextLine(), Integer.parseInt(inFile.nextLine()));
                    states.add(s1);
                }
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return states;
    }

    public static void printArray(ArrayList<State> states)
    {
        JTextArea area = new JTextArea();

        //append column headings here
        String answer = String.format("%-23s %-23s %-30s %-30s %-5s",
                "STATE NAME", "CAPITAL","FLOWER","BIRD","POPULATION"+"\n\n");
        area.append(answer);
        String name = ""; String capital = ""; String flower = ""; String bird = ""; int pop = 0;
        for (State s : states) {
            answer = String.format("%-23s %-23s %-30s %-30s %-5s", s.getStateName(), s.getStateCapital(), s.getStateBird(), s.getStateFlower(), s.getStatePopulation() + "\n");

            System.out.println(answer);
            area.append(answer);
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