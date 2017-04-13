package datastructures.stacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Dominick Martelly on 4/12/2017 at 6:01 PM.
 *
 * @author Dominick Martelly
 */

public class PoisonousPlants {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfPlants = in.nextInt();
        int max = 0;
        Stack<Integer> myStack = new Stack<>();
        int[] garden = new int[numOfPlants];
        for (int i = 0; i < numOfPlants; i++) {
            garden[i] = in.nextInt();
        }
        for (int i = garden.length-1; i >= 0; i--){
            if(myStack.empty()){
                myStack.push(garden[i]);
            } else if (myStack.peek() <= garden[i]){
                myStack.push(garden[i]);
            } else {
                int count = 0;
                while (!myStack.empty() && myStack.peek() > garden[i]){
                    myStack.pop();
                    count++;
                }
                myStack.push(garden[i]);
                max = Math.max(count, max);
            }
        }
        System.out.println(max);
    }
}