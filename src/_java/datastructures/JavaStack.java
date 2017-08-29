package _java.datastructures;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dominick on 8/29/2017.
 *
 * @author Dominick
 */
public class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(isBalanced(input) ? "true" : "false");
        }

    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (isClosing(c)) {
                if (stack.isEmpty() || !isPair(c, stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return true;
    }

    private static boolean isClosing(char input) {
        switch (input) {
            case 41:
            case 93:
            case 125:
                return true;
            default:
                return false;
        }
    }

    private static boolean isPair(Character c1, Character c2) {
        switch (c1) {
            case 40:
                return c2 == 41;
            case 91:
                return c2 == 93;
            case 123:
                return c2 == 93;
            default:
                return false;
        }
    }
}

