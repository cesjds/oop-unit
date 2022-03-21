import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StateDB
{
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<State>();

        fillAray(State);
    }

    public static String[][] fillAray(String states[][])
    {
        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));

            while (inFile.hasNext())
            {
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

}