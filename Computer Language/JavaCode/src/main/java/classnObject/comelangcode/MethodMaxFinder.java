package classnObject.comelangcode;

import java.util.Scanner;

public class MethodMaxFinder {
    public static void main(String[] args) {
        // create Scanner for input from command window
        Scanner input = new Scanner(System.in);

        // prompt for and input three floating-point values
        System.out.print(
                "Enter three floating-point values separated by spaces: ");
        double number1 = input.nextDouble(); // read first double
        double number2 = input.nextDouble(); // read second double
        double number3 = input.nextDouble(); // read third double

        // determine the maximum value
        double maximum = maximum(number1, number2, number3);

        // display maximum value
        System.out.println("Maximum is: " + maximum);
    }

    // returns the maximum of its three double parameters
    public static double maximum(double x, double y, double z) {
        double max = x; // assume x is the largest to start

        // determine whether y is greater than maximumValue
        if(max < y){
            max = y;
        }

        // determine whether z is greater than maximumValue
        if(max < z){
            max = z;
        }

        return max;
    }
}
