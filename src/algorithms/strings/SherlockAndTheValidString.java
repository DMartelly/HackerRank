package algorithms.strings;

import java.util.Scanner;

/**
 * Created by Dominick on 8/22/2017.
 *
 * @author Dominick
 */
public class SherlockAndTheValidString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }

    private static String isValid(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 97];
        }
        Integer a = 0;
        boolean flag = false;
        for (int cCount : count) {
            if (cCount != 0 && a != cCount) {
                if (a == 0) {
                    a = cCount;
                } else if (!flag && ((Math.abs(cCount - a) == 1) || cCount == 1)) {
                    flag = true;
                } else {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
