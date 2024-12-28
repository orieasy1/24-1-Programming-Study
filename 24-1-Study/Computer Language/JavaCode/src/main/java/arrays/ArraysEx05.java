package arrays;

public class ArraysEx05 {
    public static void main(String[] args) {
        int[] grade = {87, 68,94, 100, 83, 78,85, 91, 71, 87};
        int[] array = new int[11];

        for(int i = 0; i < grade.length; i++){
            int index = grade[i] / 10;
            array[index]++;
        }

        System.out.println("Grade distribution: ");

        for (int i = 0; i < array.length; i++){
            if(i == 10) {
                System.out.printf("%5d: ", 100);
            }else {
                System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            }

            for(int star = 0; star < array[i]; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
