package _java.strings;

import java.util.Scanner;

/**
 * Created by Dominick Martelly on 4/14/2017 at 10:46 PM.
 *
 * @author Dominick Martelly
 */
public class JavaStringsIntroduction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();

        System.out.println(a.length() + b.length());
        System.out.println(a.compareTo(b) <= 0 ? "No" : "Yes");
        System.out.println(capitalizeFirstLetter(a) + " " + capitalizeFirstLetter(b));
    }

    private static String capitalizeFirstLetter(String s) {
        return (s == null || s.length() == 0) ? s : s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
