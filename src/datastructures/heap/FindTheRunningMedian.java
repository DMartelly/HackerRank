package datastructures.heap;

import java.util.Scanner;

/**
 * Created by Dominick Martelly on 4/20/2017 at 12:10 AM.
 *
 * @author Dominick Martelly
 */
public class FindTheRunningMedian {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numOfNumbers = in.nextInt();
        int[] myQueue = new int[numOfNumbers];
        for (int i = 0; i < numOfNumbers; i++) {
            myQueue = insert(in.nextInt(), i, myQueue);
            if (i % 2 == 0) {
                System.out.printf("%.1f\n", (float) myQueue[i / 2]);
            } else {
                System.out.printf("%.1f\n", (float) (myQueue[i / 2] + myQueue[i / 2 + 1]) / 2);
            }
        }
    }

    private static int[] insert(int newNumber, int size, int[] arr) {
        arr[size] = newNumber;
        while (size > 0) {
            if (arr[size] < arr[size - 1]) {
                int temp = arr[size];
                arr[size] = arr[size - 1];
                arr[size - 1] = temp;
                size--;
            } else {
                return arr;
            }
        }
        return arr;
    }
}
