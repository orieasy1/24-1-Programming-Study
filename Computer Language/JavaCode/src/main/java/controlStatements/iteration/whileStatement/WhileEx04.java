package controlStatements.iteration;

import java.util.Scanner;

public class WhileEx04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int passes = 0;
        int failures = 0;
        int counter = 1;

        System.out.println("Enter 1 if you passed, enter 2 if you failed.");
        while(counter <= 10){
            System.out.print("Enter result: ");
            int result = scanner.nextInt();

            if(result == 1){
                passes++;
            }else if (result == 2){
                failures++;
            }

            counter++;
        }

        System.out.println("Passes: " + passes);
        System.out.println("Failures: " + failures);

        if(passes > 8){
            System.out.println("Bonus to instructor!");
        }
    }
}
