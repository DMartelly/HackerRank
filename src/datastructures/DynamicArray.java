package datastructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Dominick Martelly on 4/7/2017 at 6:54 PM.
 *
 * @author Dominick Martelly
 */
public class DynamicArray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int lastAns = 0;
        int numOfSequences = in.nextInt();
        int numOfQueries = in.nextInt();
        List<List<Integer>> listOfSequences = new ArrayList<>();
        for (int i = 0; i < numOfSequences; i++){
            listOfSequences.add(new ArrayList<>());
        }
        for (int i = 0; i < numOfQueries; i++){
            switch (in.nextInt()){
                //Append num to the correct sequence
                case 1:
                    listOfSequences.get(myFunction(in.nextInt(), lastAns, numOfSequences)).add(in.nextInt());
                    break;
                //Get the correct number
                case 2:
                    List<Integer> a = listOfSequences.get(myFunction(in.nextInt(), lastAns, numOfSequences));
                    int seqSize = a.size();
                    lastAns = a.get(in.nextInt() % seqSize);
                    System.out.println(lastAns);
                    break;
                default:
                    System.err.print("Error!");
                    return;
            }
        }
        in.close();
    }

    private static int myFunction(int x, int lastAns, int n){
        return (x ^ lastAns) % n;
    }
}
