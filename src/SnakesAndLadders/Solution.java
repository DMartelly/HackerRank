package SnakesAndLadders;

import com.sun.deploy.util.ArrayUtil;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Dominick Martelly on 5/16/2016 at 1:18 PM.
 *
 * @author Dominick Martelly
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        //For each test case
        for (int i = 0; i < numTestCases; i++) {
            //Store each ladder
            int numLadders = in.nextInt();
            int[] ladderStart = new int[numLadders];
            int[] ladderEnd = new int[numLadders];
            for (int j = 0; j < numLadders; j++) {
                ladderStart[j] = in.nextInt();
                ladderEnd[j] = in.nextInt();
            }
            //Store each snake
            int numSnakes = in.nextInt();
            ArrayList<Integer> snakeStart = new ArrayList<>();
            ArrayList<Integer> snakeEnd = new ArrayList<>();
            for (int j = 0; j < numSnakes; j++) {
                snakeStart.add(in.nextInt());
                snakeEnd.add(in.nextInt());
            }
            int[] countValues = new int[101];
            Arrays.fill(countValues, Integer.MAX_VALUE);
            for (int j = 0; j < countValues.length - 2; j++) {
                int count = 0;
                boolean breakOut = false;
                countValues[j + 2] = j / 6 + 1;
                for (int k = j; k < j + 6; k++) {
                    if (snakeStart.contains(k))
                        count++;
                    if (count == 6)
                        breakOut = true;
                }
                if (breakOut) {
                    break;
                }
            }
            int[] compareValues = new int[101];
            while (!Arrays.equals(compareValues, countValues)) {
                compareValues = Arrays.copyOf(countValues, countValues.length);
                //Update the count values based on ladders
                for (int k = 0; k < numLadders; k++) {
                    int newValue;
                    if (countValues[ladderEnd[k]] > countValues[ladderStart[k]]) {
                        countValues[ladderEnd[k]] = countValues[ladderStart[k]];
                        for (int j = ladderEnd[k]; j < countValues.length - 1; j++) {
                            newValue = (j - ladderEnd[k]) / 6 + countValues[ladderEnd[k]] + 1;
                            if (countValues[j + 1] > newValue) {
                                countValues[j + 1] = newValue;
                            }
                        }
                    }
                }
                //Update the count values based on snakes
                for (int k = 0; k < numSnakes; k++) {
                    int newValue;
                    if (countValues[snakeEnd.get(k)] > countValues[snakeStart.get(k)]) {
                        countValues[snakeEnd.get(k)] = countValues[snakeStart.get(k)];
                        for (int j = snakeEnd.get(k); j < countValues.length - 1; j++) {
                            newValue = (j - snakeEnd.get(k)) / 6 + countValues[snakeEnd.get(k)] + 1;
                            if (countValues[j + 1] > newValue) {
                                countValues[j + 1] = newValue;
                            }
                        }
                    }
                }
            }
            if (countValues[100] == Integer.MAX_VALUE)
                System.out.println(countValues[-1]);
            else
                System.out.println(countValues[100]);
        }
    }
}