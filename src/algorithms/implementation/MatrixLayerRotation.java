package algorithms.implementation;

import java.util.*;

public class MatrixLayerRotation {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numOfRows = in.nextInt();
        int numOfColumns = in.nextInt();
        int numOfRotations = in.nextInt();
        int[][] matrix = new int[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println("The Matrix:");
        printMatrix(matrix);

        matrix = rotateMatrix(matrix, numOfRotations);

        printMatrix(matrix);
    }

    private static int[][] rotateMatrix(int[][] matrix, int numOfRotations) {
        int circleStart = 0;
        while (circleStart < Math.min(matrix[0].length, matrix.length) / 2) {
            for (int count = 0; count < numOfRotations; count++) {
                int temp = matrix[circleStart][circleStart];
                int i = circleStart;
                int j = circleStart;
                for (; j < matrix[i].length - circleStart - 1; j++)
                    matrix[i][j] = matrix[i][j + 1];
                for (; i < matrix.length - circleStart - 1; i++)
                    matrix[i][j] = matrix[i + 1][j];
                for (; j > circleStart; j--)
                    matrix[i][j] = matrix[i][j - 1];
                for (; i > circleStart; i--)
                    matrix[i][j] = matrix[i - 1][j];
                matrix[circleStart + 1][circleStart] = temp;
            }
            circleStart++;
        }
        return new int[0][];
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.printf("%d\t", number);
            }
            System.out.println();
        }
    }
}