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
         */
        for(Book book : Book.values()) {
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


