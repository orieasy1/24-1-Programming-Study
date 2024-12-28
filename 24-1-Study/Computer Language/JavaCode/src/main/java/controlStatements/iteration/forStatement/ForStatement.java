package controlStatements.iteration.forStatement;

public class ForStatement {
    public static void main(String[] args) {
        //a) Vary the control variable from 1 to 100 in increments of 1.
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        //b) Vary the control variable from 100 to 1 in decrements of 1.
        for (int i = 100; i >= 1; i--) {
            System.out.println(i);
        }

        //c) Vary the control variable from 7 to 77 in increments of 7.
        for (int i = 7; i <= 77; i += 7) {
            System.out.println(i);
        }

        //d)Vary the control variable from 20 to 2 in decrements of 2.
        for (int i = 20; i >= 2; i -= 2) {
            System.out.println(i);
        }

        //e)Vary the control variable over the values 2, 5, 8, 11, 14, 17, 20.
        for (int i = 2; i <= 20; i += 3) {
            System.out.println(i);
        }

        //f)Vary the control variable over the values 99, 88, 77, 66, 55, 44, 33,22, 11, 0.
        for(int i = 99; i >= 0; i -= 11) {
            System.out.println(i);
        }

    }
}
