package controlStatements.iteration.whileStatement;

public class WhileEx01 {
    public static void main(String[] args) {
        int product = 3;

        while(product <= 100) {
            product *= 3;
            //product = 3 * product;

            System.out.println(product);
        }
    }
}
