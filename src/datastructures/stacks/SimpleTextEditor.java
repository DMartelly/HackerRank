package datastructures.stacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Dominick Martelly on 4/11/2017 at 6:20 PM.
 *
 * @author Dominick Martelly
 */

public class SimpleTextEditor {

    private String s = "";
    private Stack<History> history = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfQueries = in.nextInt();
        SimpleTextEditor myTextEditor = new SimpleTextEditor();
        for (int i = 0; i < numOfQueries; i++) {
            byte operation = in.nextByte();
            switch (operation) {
                case 1:
                    myTextEditor.append(in.next());
                    break;
                case 2:
                    myTextEditor.delete(in.nextInt());
                    break;
                case 3:
                    myTextEditor.print(in.nextInt());
                    break;
                case 4:
                    myTextEditor.undo();
                    break;
                default:
                    System.err.println("Error!");
                    return;

            }
        }
    }

    private void undo() {
        if (!history.empty()) {
            History lastHistory = history.pop();
            if (lastHistory.delete) {
                this.s = s.substring(0, s.length() - lastHistory.text.length());
            } else {
                this.s += lastHistory.text;
            }
        }

    }

    private void print(int i) {
        System.out.println(s.charAt(i - 1));
    }

    private void delete(int i) {
        history.push(new History(false, s.substring(s.length() - i, s.length())));
        this.s = s.substring(0, s.length() - i);
    }

    private void append(String s) {
        this.s += s;
        history.push(new History(true, s));
    }

    private class History {
        boolean delete;
        String text;

        private History(boolean toDelete, String text) {
            this.delete = toDelete;
            this.text = text;
        }
    }
}