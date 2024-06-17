package Final2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class problem02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Input Row: ");
        int row = scanner.nextInt();
        System.out.print("Input Column: ");
        int column = scanner.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                rowList.add(random.nextInt(100) + 1);
            }
            matrix.add(rowList);
        }

        // Print the generated matrix
        System.out.print("2D List: [");
        for (int i = 0; i < row; i++) {
            System.out.print("[");
            for (int j = 0; j < column; j++) {
                System.out.print(matrix.get(i).get(j));
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

        // Find the row containing the largest value
        int maxRowIndex = 0;
        int maxValue = Collections.max(matrix.get(0));

        for (int i = 0; i < row; i++) {
            Collections.sort(matrix.get(i));
            int rowMaxValue = matrix.get(i).get(column - 1);
            if (rowMaxValue > maxValue) {
                maxValue = rowMaxValue;
                maxRowIndex = i;
            }
        }

        // Print the index of the row containing the largest value
        System.out.println("Index of Row that contains the maximum value: " + maxRowIndex);
    }
}
