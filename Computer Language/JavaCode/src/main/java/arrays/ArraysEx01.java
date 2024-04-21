package arrays;

public class ArraysEx01 {
    public static void main(String[] args){
        //Creating and Initializing an Array
        int[] array = new int[10];

        //%s: 문자열 출력, %8s: 문자열을 오른쪽으로 정렬하여 출력 폭을 8칸으로 지정
        System.out.printf("%s%8s%n", "Index", "Value");
        for(int counter = 0; counter < array.length; counter++){
            System.out.printf("%d%8d%n", counter, array[counter]);
        }
    }
}
