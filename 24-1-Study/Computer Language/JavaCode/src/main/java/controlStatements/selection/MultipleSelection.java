package controlStatements.selection;

import java.util.Scanner;

public class MultipleSelection {
    public static void main(String[] argrs){
        //switch case문임
        int total = 0;
        int counter = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the integer grades in the ran 0 to 100.");
        System.out.println("Enter -1 to finish entering grade.");

        while(scanner.hasNext()) {
            int grade = scanner.nextInt();
            total += grade;
            counter++;

            switch (grade / 10){
                case 9:
                case 10:
                    aCount++;
                    break;
                case 8:
                    bCount++;
                    break;
                case 7:
                    cCount++;
                    break;
                case 6:
                    dCount++;
                    break;
                default:
                    fCount++;
                    break;
            }
        }

        System.out.println("Grade Report");

        if(counter != 0){
            System.out.println("Grades for " + counter + " students were entered.");
            System.out.printf("Total of the %d grades entered is %d.%n", counter, total);

            double avg = (double)total / counter;
            System.out.printf("Class average is %.2f%n");

            System.out.println("Number of Students who received each grade: ");
            System.out.println("A: " + aCount);
            System.out.println("B: " + bCount);
            System.out.println("C: " + cCount);
            System.out.println("D: " + dCount);
            System.out.println("F: " + fCount);
        }else {
            System.out.println("No grades were entered.");
        }
    }
}
