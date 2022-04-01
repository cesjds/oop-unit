package state;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/********************************************************************
 Written by: Yoav Amit

 ASSIGNMENT: Write a program that writes a new State database program
 using OOP and your State class.

 Your program should have a menu method that gives the user the following options:
 print, search, add, delete, exit

 print should print the entire database in the text area we used in your original program
 but using the formatting notes instead of loops to space out the columns.
 search should ask for the name of a state and search for it. If it is found the
 information for that state should be printed using the toString() from State, otherwise
 a polite "not found" message should be printed.
 add should ask for the name of the state to be added. If that state is already in the
 database you should print a message saying it is already there. Otherwise ask for
 the rest of the information and add the state. Your database should remain sorted
 by state name.
 delete should ask for the name of the state to be deleted. If the state is in the database
 it should be deleted, otherwise a polite "not found" message should be printed.
 The user should be able to continue to run your program until they chooses to exit.

 NOTES:
 You cannot use 51 as the size of the ArrayList since it will be changing.
 You can create a dummy state using the name the user inputs, 4 empty Strings and 0.
 This will be useful in search() & add() although there are other ways to write these
 two methods.
 You MUST use this for delete() - most of the delete method can be written using
 methods from the ArrayList class. There should be no loops in your delete method.
 You shouldn't print the entire database after add and delete. Your program should
 go back to the main menu and the user can choose print from there.
 Your program should be running from your main method but all that should be there
 is declaring variables, a loop to keep the program going and method calls.
 Look at my answer key to make sure your program works correctly!


 HAND IN:
 FIRST, THOROUGHLY test your program AND have someone else test it and
 try to crash it!
 SECOND, make sure your name is in comments at the top of both your State class and
 your State database programs.
 THIRD, copy and paste the code for your State class and State database into 2
 SEPERATE submissions in Schoology.

 ********************************************************************/



public class StateDB
{
    public static void main(String[] args)
    {
        ArrayList states = new ArrayList<State>();
        fillArray(states);

        //state.State s1 = new state.State(sn,sc,sf,sb,sp);

        int choice;
        do {
            choice = menu();
            switch (choice)
            {
                case 0: printArray(states); break;
                case 1: searchArray(states); break;
                case 2: addArray(states); break;
                case 3: deleteArray(states); break;
                case 4: System.exit(0); break;
            }
        } while (choice != 4);
    }

    public static int menu()
    {
        String message = "";
        message += "What do you want to do?";
        String[] buttons = {"Print",
                            "Search",
                            "Add",
                            "Delete",
                            "Quit"};

        int choice = JOptionPane.showOptionDialog
                (null, message, "Choices",
                        0, 3, null, buttons, null);

        return choice;
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

    public static void searchArray(ArrayList<State> states)
    {
        String state = JOptionPane.showInputDialog("What state would you like to search for?");

        int counter = 0;
        String message = "";

        State s = new State(state.toUpperCase(), null, null, null, 0);

        while (!states.contains(s) && counter < states.size())
            counter ++;

        if (counter == states.size())
            message += "Sorry, the state was not found in the database";
        else {
            int index = states.indexOf(s);
            message += "state name: " + s.getStateName() + "\n";
            message += "state capital: " + states.get(states.indexOf(s)).getStateCapital() + "\n";
            message += "state flower: " + states.get(states.indexOf(s)).getStateFlower() + "\n";
            message += "state bird: " + states.get(states.indexOf(s)).getStateBird() + "\n";
            message += "state population: " + states.get(states.indexOf(s)).getStatePopulation() + "\n";
        }

        JOptionPane.showMessageDialog(null, message);
    }

    public static ArrayList<State> addArray(ArrayList<State> states)
    {
        String stateToAdd = JOptionPane.showInputDialog("Enter the name of the state you would like to add");




        int counter = 0;
        String message = "";

        for (State s : states) {
            if (s.getStateName().equalsIgnoreCase(stateToAdd)) {
                message += "Sorry, this state is already in the database";
                JOptionPane.showMessageDialog(null, message);
                menu();
            }
            counter ++;
        }

        message = "";

        String capitalToAdd = "";
        String flowerToAdd = "";
        String birdToAdd = "";
        int populationToAdd = 0;


        if (counter == states.size()) {
            capitalToAdd = JOptionPane.showInputDialog("Enter the name of the capital you would like to add");
            flowerToAdd = JOptionPane.showInputDialog("Enter the name of the flower you would like to add");
            birdToAdd = JOptionPane.showInputDialog("Enter the name of the bird you would like to add");
            populationToAdd = Integer.parseInt(JOptionPane.showInputDialog("Enter the population you would like to add"));
        }

        State s1 = new State(stateToAdd.toUpperCase(), capitalToAdd.toUpperCase(), flowerToAdd.toUpperCase(), birdToAdd.toUpperCase(), populationToAdd);
        states.add(s1);
        Collections.sort(states);
        message += "The state has been added to the database";

        JOptionPane.showMessageDialog(null, message);
        return states;
    }

   public static ArrayList<State> deleteArray(ArrayList<State> states)
   {
       String stateToRemove = JOptionPane.showInputDialog("Enter the name of the state you would like to remove");

       State s = new State(stateToRemove.toUpperCase(), null, null, null, 0);

       String message = "";

       if (states.contains(s)) {
           int index = states.indexOf(s);
           states.remove(index);
           message += "The state " + stateToRemove.toUpperCase() + " has been successfully removed from the database";
       }
       else {
           message += "Sorry, this state was not found in the database";
       }

       JOptionPane.showMessageDialog(null, message);
       return states;
   }
}