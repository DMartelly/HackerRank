package algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        while (x1 <= x2) {
            if (x1 == x2) {
                return "YES";
            }
            int diff1 = x2 - x1;
            x1 += v1;
            x2 += v2;
            int diff2 = x2 - x1;
            if (diff2 >= diff1) {
                return "NO";
            }
        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
