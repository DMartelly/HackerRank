package algorithms.strings;

import java.util.Scanner;

/**
 * Created by Dominick on 8/23/2017.
 *
 * @author Dominick
 */
public class SuperReducedString {

    private static String super_reduced_string(String s){
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1){
                ans.append(chars[i]);
                continue;
            }
            if (chars[i] == chars[i+1]){
                i++;
                continue;
            }
            ans.append(chars[i]);
        }
        if (s.equals(ans.toString()))
            return ans.length() == 0 ? "Empty String" : ans.toString();
        else return super_reduced_string(ans.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
