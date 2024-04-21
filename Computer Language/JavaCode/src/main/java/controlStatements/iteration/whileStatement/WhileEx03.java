package controlStatements.iteration.whileStatement;

import java.util.Scanner;

public class WhileEx03 {
    public static void main(String[] args){
        //Sentinel Controlled Iteration
        Scanner scanner = new Scanner(System.in);

        double total= 0.0;
        int counter = 0;

        System.out.println("Enter the first grade. (Sentinel code: -1)");
        double grade = scanner.nextDouble();

        //Ex02는 입력 개수에 따라 반복문을 멈췄고 이건 sentinel 코드가 입력되었느냐 안되었느냐에 따라 멈춤
        while(grade != -1) {
            total += grade;
            counter++;
            System.out.println("Enter the first grade. (Sentinel code: -1)");grade = scanner.nextDouble();
        }

        if(counter != 0) {
            double avg = total / counter;
            System.out.println("The class average: " + avg);
        }else {
            System.out.println("No grades were entered");
        }

    }
}

