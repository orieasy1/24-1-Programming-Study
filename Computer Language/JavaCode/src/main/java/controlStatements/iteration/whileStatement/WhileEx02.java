package controlStatements.iteration;

import java.util.Scanner;

public class WhileEx02 {
    public static void main(String[] args){
        //Counter Controlled Iteration
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        double total= 0.0;

        while(counter < 10) {
            System.out.println("Input your grade. Grade should be in the range 0 to 100.");
            double score = scanner.nextDouble();
            total += score;
            counter++;
        }

        double avg = total / 10;
        System.out.println("The class average: " + avg);
    }
}
