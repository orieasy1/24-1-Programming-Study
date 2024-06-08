package Final2023;

import java.util.Random;
import java.util.Scanner;

public class problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input Row: ");
        int row = scanner.nextInt();
        System.out.print("Input Column: ");
        int column = scanner.nextInt();

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(100) + 1;
            }
        }

        // Print the generated matrix
        System.out.print("2D List: [");
        for (int i = 0; i < row; i++) {
            System.out.print("[");
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < row - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int maxRowIndex = 0;
        int maxValue = matrix[0][0];

        for
        /*for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    maxRowIndex = i;
                }
            }
        }*/

        // Print the index of the row containing the largest value
        System.out.println("Index of Row that contains the maximum value: " + maxRowIndex);
    }
}
