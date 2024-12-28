package classnObject2.timeclasscase;

// Fig. 8.1: Time1.java
// Time1 class declaration maintains the time in 24-hour format.

public class Time1 {
    /* Instructions
     * Declare integer variables representing hour, minute and second.
     * Remember to follow the information hiding principles!
     */
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    // set a new time value using universal time; throw an
    // exception if the hour, minute or second is invalid
    public void setTime(int hour, int minute, int second) {
        // validate hour, minute and second
        if (hour < 0 || hour > 24 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            /* Instructions
             * Use the "throw" keyword to raise an IllegalArgumentException
             * Add a meaningful error message.
             */
            throw new IllegalArgumentException(
                    //Write down error message which you want to make it appear.
                    "It is out of range of hour or minute of second.");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d : %02d : %02d", hour, minute, second);
    }

    // convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {

        /* Instructions
         * Use the ternary operator " ? : " to print the hour in  0-12 format
         * Note: That ternary operator is also known as Java One line if statement
         *      Syntax -->  condition ? expression1 : expression2;
         */


        return String.format("%d:%02d:%02d %s" ,
                ((hour == 0 || hour == 12) ? 2 : hour %12),
                //       조건식             참 일때  거짓일때
                minute, second, (hour < 12 ? "AM" : "PM"));
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