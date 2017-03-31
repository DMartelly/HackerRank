package Test;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            phoneBook.put(in.next(), in.nextInt());
        }
        while (in.hasNext()) {
            String s = in.next();
            if (!phoneBook.containsKey(s))
                System.out.println("Not found");
            else
                System.out.println(s + "=" + phoneBook.get(s));
        }
        in.close();
    }
}