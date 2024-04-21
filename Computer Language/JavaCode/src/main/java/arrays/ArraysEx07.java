package arrays;

public class ArraysEx07 {
    public static void main(String[] args) {

        int[] responses = {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 3, 2, 3, 3, 2, 14};
        int[] frequency = new int[6];

        for (int i = 0; i < responses.length; i++) {
            try{
                frequency[responses[i]]++;
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                System.out.printf("responses[%d] = %d%n", i ,responses[i]);
            }
        }
    }
}
