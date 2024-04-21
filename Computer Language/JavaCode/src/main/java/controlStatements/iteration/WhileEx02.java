package controlStatements.iteration;

import java.util.Scanner;

public class WhileEx02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int grade = 0;
        double total= 0.0;
        double avg = 0.0;

        while(grade < 10) {
            System.out.println("Input your grade. Grade should be in the range 0 to 100.");
            double score = scanner.nextDouble();
            total += score;
            grade++;
        }

        avg = total / 10;
        System.out.println("The class average: " + avg);
    }
}
