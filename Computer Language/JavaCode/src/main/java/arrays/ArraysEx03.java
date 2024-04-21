package arrays;

public class ArraysEx03 {
    public static void main(String[] args) {
        //Calculating the Values to Store in an Array
        final int array_length = 10;
        int[] array = new int[array_length];

        for (int counter = 0; counter < array_length; counter++) {
            array[counter] = 2 + 2 * counter;
        }

        System.out.printf("%s%8s%n", "Index", "Value");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5d%8d%n", i, array[i]);
        }
    }
}
