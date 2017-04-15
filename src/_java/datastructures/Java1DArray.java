package _java.datastructures;

import java.util.Scanner;

/**
 * Created by Dominick Martelly on 3/30/2017 at 7:53 PM.
 *
 * @author Dominick Martelly
 */
public class Java1DArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        in.close();
        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
