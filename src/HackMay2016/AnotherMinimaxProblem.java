package HackMay2016;

import java.util.Scanner;

/**
 * Created by Dominick Martelly on 5/17/2016 at 1:08 PM.
 *
 * @author Dominick Martelly
 */
public class AnotherMinimaxProblem {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int numOfIntegers = in.nextInt();
        long[] myArray = new long[numOfIntegers];
        for (int i = 0; i < numOfIntegers; i++) {
            myArray[i] = in.nextInt();
        }
        System.out.println((myArray[0] ^ myArray[1]));
    }
}
