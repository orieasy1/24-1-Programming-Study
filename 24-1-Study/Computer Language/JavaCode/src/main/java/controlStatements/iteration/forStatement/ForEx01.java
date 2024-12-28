package controlStatements.iteration.forStatement;

public class ForEx01 {
    public static void main(String[] args){
        //Compound interest application 초안
        int principal = 1000;
        double r = 0.05;

        for(int i = 1; i <= 10; i++) {
            double deposit = (double)principal * (1 + r);
            System.out.println("Amount of deposit at the end of the " + i + "th year: " + deposit);
        }
    }
}
