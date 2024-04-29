package classnObject2.overloadedConstructors;

// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.

public class Time2 {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    /* Time2 no-argument constructor:
     *  Instructions
     *  Create a SECOND overloaded constructor with no arguments that initializes
     *  each instance variable to zero
     *  Hint: use the FIRST constructor that we already declared
     *
     */

    public Time2() {
        this(0, 0, 0);
    }

    /* Time2 one argument constructor:
     *  Instructions
     *  Create a THIRD overloaded constructor in which the hour is supplied,
     *  but minute and second are defaulted to 0
     *  Hint: use the FIRST constructor that we already declared
     *
     */
    public Time2(int hour){
        this(hour, 0, 0);
    }

    /* Time2 two arguments constructor:
     *  Instructions
     *  Create a FOURTH overloaded constructor in which the hour and the minute
     *  are supplied, but the second is defaulted to 0
     *  Hint: use the FIRST constructor that we already declared
     *
     */
    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }

    /* Time2 three arguments constructor:
     *  Instructions
     *  Create the FIRST Time2 constructor: hour, minute and second supplied
     *  You have to validate each parameter, and throw a IllegalArgumentException if
     * you find invalid values for hour, minute or second
     */
    public Time2(int hour, int minute, int second) {

        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be in 0 to 59");
        }

        if(second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be in 0 to 59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /* Time2 constructor using another Time2 object
     *  Instructions
     *  Create a FIFTH overloaded constructor in which another Time2 object
     *  is supplied
     *  Hint: use the FIRST constructor that we already declared
     *
     */
    /* add an overloaded constructor */

    // Set Methods
    // set a new time value using universal time;
    // validate the data
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }

        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }

        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /* create a setHour method */

    /* add a setMinute method */

    /* add a setSecond object */

    // Get Methods
    // get hour value
    public int getHour() {return hour;}

    // get minute value
    public int getMinute() {return minute;}

    // get second value
    public int getSecond() {return second;}

    // convert to String in universal-time format (HH:MM:SS)
    public String toUniversalString() {
        return String.format(
                "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    // convert to String in standard-time format (H:MM:SS AM or PM)
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
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
