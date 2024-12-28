package controlStatements.iteration.forStatement;

public class ForEx03 {
    public static void main(String[] args) {
        //Compound interest application Math Class 적용ver
        //Math 클래스의 정적 메서드 pow를 사용하여 거듭제곱 사용 가능
        //Math.pow(x,y)는 x^y와 같음
        double principal = 1000;
        double r = 0.05;

        for(int i = 1; i <= 10; i++) {
            double deposit = principal * Math.pow(1 + r, i);
            System.out.printf("The amount of deposit at the end of the %dth year: $%20.2f%n", i, deposit);
        }

    }
}
