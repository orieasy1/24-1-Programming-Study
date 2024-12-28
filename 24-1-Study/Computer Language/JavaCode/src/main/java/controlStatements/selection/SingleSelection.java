package controlStatements.selection;

import java.util.Scanner;

public class SingleSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentGrade = scanner.nextInt();

        //Single selection statement
        if (studentGrade >= 60) {
            System.out.println("Passed");
        }

    }
}
