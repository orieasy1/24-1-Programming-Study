package controlStatements.iteration;

import java.util.Scanner;

public class WhileStatement {
    public static void main(String[] args) {
        int product = 3;

        while(product <= 100) {
            product *= 3;
            //product = 3 * product;

            System.out.println(product);
        }
    }
}
