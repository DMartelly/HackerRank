package _java.datastructures;

import java.util.*;

public class Java2DArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        System.out.println(hourglassSum(arr));
    }

    private static int hourglassSum(int[][] arr) {
        int sum = 0,
            maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++){
            for (int j = 0; j < arr[i].length - 2; j++){
                sum += arr[i][j] + arr[i][j+1] + arr[i][j+2];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                maxSum = Math.max(sum, maxSum);
                sum = 0;
            }
        }
        return maxSum;
    }
}