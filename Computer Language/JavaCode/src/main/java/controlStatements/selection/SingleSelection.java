package controlStatements.selection;

import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentGrade = scanner.nextInt();

        //Single selection statement
        if (studentGrade >= 60) {
            System.out.println("Passed");
        }

        //Double selection statement1 : if~else
        if(studentGrade >= 60) {
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        //Double selection statement2 : if~else
        if(studentGrade >= 90) {
            System.out.println("A");
        }else if(studentGrade >= 80) {
            System.out.println("B");
        }else if (studentGrade >= 70) {
            System.out.println("C");
        }else if (studentGrade >= 60) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
}
