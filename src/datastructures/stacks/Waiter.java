package datastructures.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dominick Martelly on 4/18/2017 at 7:39 PM.
 *
 * @author Dominick Martelly
 */
public class Waiter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfStackedPlates = in.nextInt();
        int numOfIterations = in.nextInt();
        int currPrimeNumber = 1;
        Stack<Integer> a = new Stack<>();
        for (int i = 0; i < numOfStackedPlates; i++) {
            a.push(in.nextInt());
        }
        Stack<Integer> b = new Stack<>();
        for (int i = 0; i < numOfIterations; i++) {
            currPrimeNumber++;
            while (!isPrime(currPrimeNumber)) {
                currPrimeNumber++;
            }
            Stack<Integer> temp = a;
            Stack<Integer> newB = new Stack<>();
            a = new Stack<>();
            while (!temp.isEmpty()) {
                int curr = temp.pop();
                if (curr % currPrimeNumber == 0) {
                    newB.push(curr);
                } else {
                    a.push(curr);
                }
            }
            newB.addAll(b);
            b = newB;
        }
        while (!b.isEmpty()) {
            System.out.println(b.pop());
        }
        while (!a.isEmpty()) {
            System.out.println(a.pop());
        }
    }


    private static boolean isPrime(int n) {
        if (n % 2 == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        int step = 4, m = (int) Math.sqrt(n) + 1;
        for (int i = 5; i < m; step = 6 - step, i += step) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
