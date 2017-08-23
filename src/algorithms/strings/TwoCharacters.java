package algorithms.strings;

import java.util.*;

/**
 * Created by Dominick on 8/23/2017.
 *
 * @author Dominick
 */
public class TwoCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        String s = in.next();
        Set<String> possibleStrings = possibleStrings(s);
        int max = 0;
        for (String s1 : possibleStrings) {
            int length = s1.length();
            if (length > max && isValid(s1)) {
                max = length;
            }
        }
        System.out.println(max);
    }

    private static boolean isValid(String s1) {
        char[] chars = s1.toCharArray();
        char c = 0;
        for (char aChar : chars) {
            if (c == aChar) return false;
            c = aChar;
        }
        return true;
    }

    private static Set<String> possibleStrings(String s) {
        Set<String> result = new HashSet<>();
        List<Character> distinctChars = distinctChars(s);
        for (int i = 0; i < distinctChars.size(); i++) {
            for (int j = i + 1; j < distinctChars.size(); j++) {
                result.add(chooseTwo(s, distinctChars.get(i), distinctChars.get(j)));
            }
        }
        return result;
    }

    private static String chooseTwo(String s, Character c, Character c1) {
        String s1 = "[^" + c + c1 + "]+";
        return s.replaceAll(s1, "");
    }

    private static List<Character> distinctChars(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!result.contains(c))
                result.add(c);
        }
        return result;
    }
}
