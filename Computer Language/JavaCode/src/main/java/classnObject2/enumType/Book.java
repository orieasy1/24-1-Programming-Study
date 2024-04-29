package classnObject2.enumType;

// Fig. 8.10: Book.java
// Declaring an enum type with a constructor and explicit instance fields
// and accessors for these fields

public enum Book {
    // declare constants of enum type
    JHTP("Java How to Program", "2018"),
    CHTP("C How to Program", "2016"),
    IW3HTP("Internet & World Wide Web How to Program", "2012"),
    CPPHTP("C++ How to Program", "2017"),
    VBHTP("Visual Basic How to Program", "2014"),
    CSHARPHTP("Visual C# How to Program", "2017");

    /* Enum instance fields
     *  Instructions
     *  Create two instance fields for the Book enum, according to the
     *  information provided in the constructor of each element
     *  Note: Do not forget to use the correct access modifiers
     *
     */
    private final String title;
    private final String year;

    /* Enum constructor
     *  Instructions
     *  Declare the Book enum constructor in which you initialize
     *  the instance fields declared before
     *
     */
    Book(String title, String year) {
        this.title = title;
        this.year = year;
    }

    /* Enum instance accessor methods
     *  Instructions
     *  Declare the accessor methods for the two instance fields
     *  that you created before.
     *  Note: Remember that accessor methods are designed to be used
     *  by the clients of our class, so you should use the correct access modifier.
     *
     */
    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
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

