package _java.bignumber;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Dominick on 9/1/2017.
 *
 * @author Dominick
 */
public class JavaBigDecimal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        for (int i = 0; i < s.length - 2; i++) {
            for (int j = 0; j < s.length - 3 - i; j++) {
                if (new BigDecimal(s[j]).compareTo(new BigDecimal(s[j + 1])) < 0) {
                    String temp = s[j + 1];
                    s[j + 1] = s[j];
                    s[j] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}