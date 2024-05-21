package homework.hw2;

import java.util.Scanner;

public class Hw2Ex03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Operation >> ");
        int n = scan.nextInt();
        String operator = scan.next();
        int m = scan.nextInt();

        switch(operator) {
            case "+":
                System.out.println(n + operator + m + "= " + (n + m));
                break;
            case "-":
                System.out.println(n + operator + m + "= " + (n - m));
                break;
            case "*":
                System.out.println(n + operator + m + "= " + (n * m));
                break;
            case "/":
                if(m == 0) {
                    System.out.println("cannot divide by 0.");
                } else {
                    System.out.println(n + operator + m + "= " +(n / m));
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }
    }
}
