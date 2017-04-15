package _java.datastructures;

import java.util.*;
import java.io.*;

class JavaMap {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        PhoneBook myPhoneBook = new PhoneBook();
        for (int i = 0; i < n; i++) {
            myPhoneBook.put(in.nextLine(), in.nextInt());
            in.nextLine();
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