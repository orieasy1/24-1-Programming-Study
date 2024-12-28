package homework.hw3;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        int[][] t = new int[2][3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.println("Enter the value for t[" + i + "][" + j + "]: ");
                t[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + "  1");
            }
            System.out.println();
        }

        scanner.close();

    }
}
