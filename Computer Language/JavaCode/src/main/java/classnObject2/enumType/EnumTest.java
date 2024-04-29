package classnObject2.enumType;

// Fig. 8.11: EnumTest.java
// Testing enum type Book.
import java.util.EnumSet;

public class EnumTest {
    public static void main(String[] args) {

        System.out.println("All books:");

        /* Print all books in enum Book
         *  Instructions
         *  Use an enhanced for statement to print all
         *  the books in enum Book.
         *  Hint: use the Book.values() method to get a list
         *  of all the constants defined in the enum Book
         *
         */for(Book book : Book.values()) {
            System.out.println(book.getTitle() + "(" + book.getYear() + ")");
        }

        System.out.printf("%nDisplay a range of enum constants:%n");

        /* Print first four books in enum Book
         *  Instructions
         *  Use an enhanced for statement to print only
         *  the first four books in enum Book.
         *  Hint: use the EnumSet.range() method to get a list
         *  of the first four constants defined in the enum Book
         *
         */
        /* use an enhanced for statement to print the first four books */
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
