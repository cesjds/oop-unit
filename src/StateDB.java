import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class StateDB
{
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<State>();


        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));

            while (inFile.hasNext())
            {
                for (int r = 0; r < 51; r++)
                {
                    State s1 = new State(states[r][0]);
                }
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}