// Yoav Amit
// March 19, 2022
// Computer Programming II

import javax.swing.*;
import java.util.ArrayList;

public class StateRunner
{
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<State>();

        State s1 = new State("Maryland","Annapolis","Cool Flower","AwesomeBird",1000000);
        State s2 = new State();
        //State s3 = new State("Maryland","Annapolis","Black-eyed Susan","Cardinal",-1);

        System.out.println("Testing the Parameter Constructor: " + s1);
        System.out.println("Testing the Default Constructor: " + s2);
        //System.out.println("Testing the Negative Constructor: " + s3);

        s2.setStateName("Alaska");
        s2.setStateCapital("Juneau");
        s2.setStateFlower("Forget-me-not");
        s2.setStateBird("Willow Ptarmigan");
        s2.setStatePopulation(600000000);
        System.out.println("Testing the Setters: " + s2);

        System.out.println("Testing compareTo(), it should be 12: " + s1.compareTo(s2));
        System.out.println("Testing compareTo(), it should be -12: " + s2.compareTo(s1));
        System.out.println("Testing compareTo(), it should be 0: " + s1.compareTo(s1));

        System.out.println("Testing equals(), it should be false: " + s1.equals(s2));
        System.out.println("Testing equals(), it should be true: " + s1.equals(s1));

    }
}
