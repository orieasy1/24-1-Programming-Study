import java.util.Scanner;

public class ExampleGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = num1 % num2;

        while(num3 == 0){
            num3 = num1 % num2;

        }
    }
}
