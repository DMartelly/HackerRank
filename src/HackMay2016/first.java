package HackMay2016;

import java.io.*;
import java.util.*;

/**
 * Created by Dominick Martelly on 5/17/2016 at 12:21 PM.
 *
 * @author Dominick Martelly
 */
public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] Sticks = new int[in.nextInt()];
        for (int i = 0; i < Sticks.length; i++) {
            Sticks[i] = in.nextInt();
        }

        int maxLength = 0;
        String output = "";
        for (int i = 0; i < Sticks.length - 2; i++) {
            int firstLength = Sticks[i];
            for (int j = i + 1; j < Sticks.length - 1; j++) {
                int secondLength = Sticks[j];
                for (int k = j + 1; k < Sticks.length; k++) {
                    int thirdLength = Sticks[k];
                    if (isDegenerate(firstLength, secondLength, thirdLength))
                        continue;
                    if (firstLength + secondLength + thirdLength > maxLength) {
                        maxLength = firstLength + secondLength + thirdLength;
                        output = firstLength + " " + secondLength + " " + thirdLength;
                    }
                }
            }
        }
        //If no triangle found
        if (maxLength == 0)
            System.out.println("-1");
        else
            System.out.println(output);
    }

    private static boolean isDegenerate(int firstLength, int secondLength, int thirdLength) {
        int longest = firstLength;
        if (secondLength > longest)
            longest = secondLength;
        if (thirdLength > longest)
            longest = thirdLength;

        return !(longest < firstLength + secondLength + thirdLength - longest);
    }
}
