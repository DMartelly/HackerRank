package Test;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        PhoneBook myPhoneBook = new PhoneBook();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int number = in.nextInt();
            in.nextLine();
            myPhoneBook.put(name, number);
        }
        while (in.hasNext()) {
            System.out.println(myPhoneBook.read(in.nextLine()));
        }
        in.close();
    }

    private static class PhoneBook extends HashMap<String, Integer> {
        private String read(String name){
            return this.containsKey(name) ? name + "=" + this.get(name) : "Not found";
        }
    }
}