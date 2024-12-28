package classnObject2.timeclasscase;

// Fig. 8.2: Time1Test.java
// Time1 object used in an app.

public class Time1Test {
    public static void main(String[] args) {
        /* Instructions
         * Create and initialize a Time1 object
         */
        Time1 time = new Time1(); // invokes Time1 constructor

        // output string representations of the time
        displayTime("After time object is created", time);
        System.out.println();

        /* Instructions
         * change time and output updated time
         */
        time.setTime(13, 27, 6);
        displayTime("After calling setTime", time);
        System.out.println();

        /* Instructions
         * We will attempt to set time with invalid values
         * 1. Analyze the structure of the try catch statement
         * 2. Set an illegal time (values out of range)
         * 3. Catch an IllegalArgumentException exception
         */
        try {
            time.setTime(48, 67, 82); // all values out of range
        }
        catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }

        // display time after attempt to set invalid values
        displayTime("After calling setTime with invalid values", time);
    }

    // displays a Time1 object in 24-hour and 12-hour formats
    private static void displayTime(String header, Time1 t) {
        /* Instructions
         * 1. Analyze the format string
         * 2. Fill out the two time formats that we created in Time1 class
         */

        System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n",
                header, t.toUniversalString(), t.toString());
    }
}



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

