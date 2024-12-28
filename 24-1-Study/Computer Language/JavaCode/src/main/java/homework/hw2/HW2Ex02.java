package homework.hw2;

import java.util.Scanner;

public class HW2Ex02 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Input 2digit number (10~99): ");
        int num = scan.nextInt();

        if(num % 11 == 0) {
            System.out.println("Yes! two numbers are same!");
        }else {
            System.out.println(("No! two number are NOT same!"));
        }
    }
}
