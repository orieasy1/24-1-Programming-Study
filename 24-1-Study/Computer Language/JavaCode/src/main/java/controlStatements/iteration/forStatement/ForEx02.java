package controlStatements.iteration.forStatement;

public class ForEx02 {
    public static void main(String[] args) {
        //Compound interest application 형식지정자 적용ver
        int principal = 1000;
        double r = 0.05;

        for(int i = 1; i <= 10; i++) {
            double deposit = (double)principal * (1 + r);
            System.out.printf("The amount of deposit at the end of the %dth year: $%20.2f%n", i, deposit);
            //귀찮아서 th로 통일했는데 st, nd, rd도 추가해줄려면
            //System.out.printf("The amount of deposit at the end of the %d%s year: $%.2f%n", i, (i == 1) ? "st" : (i == 2) ? "nd" : (i == 3) ? "rd" : "th", deposit);
            //이렇게 써주면 됨
        }
    }
}
