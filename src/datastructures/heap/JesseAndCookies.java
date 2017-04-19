package datastructures.heap;

import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Dominick Martelly on 4/19/2017 at 6:45 PM.
 *
 * @author Dominick Martelly
 */
public class JesseAndCookies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCookies = in.nextInt();
        int minimumSweetness = in.nextInt();
        AbstractQueue<Integer> t = new PriorityQueue<>();
        for (int i = 0; i < numOfCookies; i++) {
            t.add(in.nextInt());
        }
        int count = 0;
        while (!(t.peek() >= minimumSweetness)) {
            if (t.size() <= 1) {
                System.out.println(-1);
                return;
            } else {
                int smallestCookie = t.remove();
                int secondSmallestCookie = t.remove();
                t.add((smallestCookie + 2 * secondSmallestCookie));
                count++;
            }
        }
        System.out.println(count);
    }
}
