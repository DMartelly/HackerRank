package algorithms.implementation;

import java.util.*;

public class MatrixLayerRotation {

    private static class Location{
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }
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
        System.out.println("\nThe Matrix Rotated " + numOfRotations +" Times:");
        printMatrix(rotateMatrix(matrix, numOfRotations));
    }

    private static int[][] rotateMatrix(int[][] matrix, int numOfRotations) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Location newPoint = algorithm(i, j, matrix.length, matrix[i].length, numOfRotations);
                newMatrix[newPoint.getX()][newPoint.getY()] = matrix[i][j];
            }
        }
        /*
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
        */
        return newMatrix;
    }

    private static Location algorithm(int i, int j, int length, int length1, int numOfRotations) {
        return new Location(i, j);
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