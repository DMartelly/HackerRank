package datastructures.stacks;

import java.util.*;

/**
 * Created by Dominick Martelly on 4/9/2017 at 8:34 PM.
 *
 * @author Dominick Martelly
 */

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            System.out.println(balanced(s));
        }
        in.close();
    }

    private static String balanced(String s){
        Stack<Character> myStack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '[' || c == '(' || c == '{'){
                myStack.push(c);
            } else {
                if (myStack.empty()){
                    return "NO";
                }
                if (myStack.pop() != open(c)){
                    return "NO";
                }
            }
        }
        return myStack.empty() ? "YES":"NO";
    }

    private static char open(char c) {
        if (c == '}')
            return '{';
        if (c == ')')
            return '(';
        if (c == ']')
            return '[';
        return 'F';
    }
}
