package _java.strings;

import java.util.Scanner;

/**
 * Created by Dominick Martelly on 12/10/2019 at 2:54 PM.
 *
 * @author Dominick Martelly
 */

public class BeautifulBinaryStrings {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulBinaryString function below.
    private static int beautifulBinaryString(String b) {
        int ans = 0, s = 0;
        char[] charArray = b.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (s >= 2) {
                if (c == '0') {
                    ans++;
                }
                s = 0;
            } else if (s == 1) {
                if (c == '1') {
                    s = 2;
                }
            } else if (c == '0') {
                s = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        System.out.println((result));

        scanner.close();
    }
}

