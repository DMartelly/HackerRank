package algorithms.strings;

import java.util.Scanner;

import static java.lang.Character.isUpperCase;

/**
 * Created by Dominick on 8/23/2017.
 *
 * @author Dominick
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = 1;
        for (char c : s.toCharArray()) {
            if (isUpperCase(c)) result++;
        }
        System.out.println(result);
    }
}
