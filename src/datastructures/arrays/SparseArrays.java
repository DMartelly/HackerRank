package datastructures.arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SparseArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short numOfStrings = in.nextShort();
        Hashtable<String, Short> myHashTable = new Hashtable<>();
        for (short i = 0; i < numOfStrings; i++){
            String s = in.next();
            if (!myHashTable.containsKey(s)){
                myHashTable.put(s, (short)1);
            } else {
                short a = myHashTable.get(s);
                myHashTable.replace(s, ++a);
            }
        }
        short numOfQueries = in.nextShort();
        for (short i = 0; i < numOfQueries; i++){
            String s = in.next();
            System.out.println(myHashTable.get(s) == null ? 0 : myHashTable.get(s));
        }
        in.close();
    }
}