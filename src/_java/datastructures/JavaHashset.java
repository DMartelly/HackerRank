package _java.datastructures;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Dominick Martelly on 4/6/2017 at 6:16 PM.
 *
 * @author Dominick Martelly
 */
public class JavaHashset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = in.next();
            pair_right[i] = in.next();
        }
        HashSet<String> myHashSet = new HashSet<>();

        for (int i = 0; i < t; i++){
            myHashSet.add(pair_left[i] + ", " + pair_right[i]);
            System.out.println(myHashSet.size());
        }
    }
}
