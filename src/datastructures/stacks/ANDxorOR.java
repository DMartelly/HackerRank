package datastructures.stacks;

import java.io.*;
import java.util.*;

/**
 * Created by Dominick Martelly on 4/14/2017 at 8:35 PM.
 *
 * @author Dominick Martelly
 */
public class ANDxorOR {
    public static void main(String[] args) {
        int array[];
        if (args.length == 1){
           array = new int[5];
           array[0] = 9;
           array[1] = 6;
           array[2] = 3;
           array[3] = 5;
           array[4] = 2;
        } else {
            Scanner in = new Scanner(System.in);
            array = new int[in.nextInt()];
            for (int i = 0; i < array.length; i++) {
                array[i] = in.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 2; j < array.length + 1; j++) {
                max = Math.max(max, function(twoSmallest(Arrays.copyOfRange(array,i,j))));
            }
        }
        System.out.println(max);
    }

    private static Tuple twoSmallest(int[] array) {
        if (array.length < 2){
            throw new IllegalArgumentException("The array needs to be greater than 1");
        }
        if (array.length == 2){
            return new Tuple(array[0], array[1]);
        }
        int smallest, secondSmallest;
        smallest = Math.min(array[0], array[1]);
        secondSmallest = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            if (array[i] < smallest){
                secondSmallest = smallest;
                smallest = array[i];
            } else if (array[i] < secondSmallest){
                secondSmallest = array[i];
            }
        }
        return new Tuple(smallest, secondSmallest);
    }

    private static int function(Tuple tuple) {
        return (((tuple.a & tuple.b) ^ (tuple.a | tuple.b)) & (tuple.a ^ tuple.b));
    }

    private static class Tuple{
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
