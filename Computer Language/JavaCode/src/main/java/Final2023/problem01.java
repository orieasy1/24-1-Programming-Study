package Final2023;

import java.util.Scanner;

public class problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println("Input your number: ");
        int num = scanner.nextInt();

        while(num != 1) {
            if(num % 2 == 0) {
                num /= 2;
            } else{
                num = 3*num + 1;
            }
            count++;
        }

        System.out.println("We needs " + count + " runs!");
    }
}
