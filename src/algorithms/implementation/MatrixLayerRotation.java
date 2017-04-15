package algorithms.implementation;

import java.util.*;

public class MatrixLayerRotation {

    public static void main(String[] args) {
        int heightOfMatrix, widthOfMatrix, numOfRotations;
        int[][] matrix;
        Scanner in = new Scanner(System.in);
        heightOfMatrix = in.nextInt();
        if (heightOfMatrix < 2 || heightOfMatrix > 300)
            System.exit(1);
        widthOfMatrix = in.nextInt();
        if (widthOfMatrix < 2 || widthOfMatrix > 300)
            System.exit(1);
        if (Math.min(heightOfMatrix, widthOfMatrix) % 2 != 0)
            System.exit(3);

        numOfRotations = in.nextInt();
        if (numOfRotations < 1 || numOfRotations > (int) Math.pow(10, 9))
            System.exit(2);

        matrix = new int[heightOfMatrix][widthOfMatrix];
        for (int i = 0; i < heightOfMatrix; i++) {
            for (int j = 0; j < widthOfMatrix; j++) {
                matrix[i][j] = in.nextInt();
                if (matrix[i][j] < 1 || matrix[i][j] > (int) Math.pow(10, 8))
                    System.exit(4);
            }
        }

        //printMatrix(matrix);
        //Insert code here
        int circleStart = 0;
        while (circleStart < Math.min(heightOfMatrix, widthOfMatrix) / 2) {
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
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}