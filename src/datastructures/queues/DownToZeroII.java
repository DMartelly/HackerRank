package datastructures.queues;

import java.util.Scanner;

/**
 * Created by Dominick Martelly on 4/22/2017 at 1:36 PM.
 *
 * @author Dominick Martelly
 */
public class DownToZeroII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfQueries = in.nextInt();
        for (int i = 0; i < numOfQueries; i++) {
            int currNumber = in.nextInt();
            int minMoves = 0;
            while (currNumber != 0) {
                if (isPrime(currNumber)) {
                    currNumber--;
                    minMoves++;
                }
                //Fill in answer here
            }
            System.out.println(minMoves);
        }
    }

    private static boolean isPrime(int n) {
        if (n > 2 && (n & 1) == 0)
            return false;
        for (int i = 3; i * i < n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
