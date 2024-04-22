// Fig. 6.7: RollDie.java
// Die-rolling program using arrays instead of switch.
import java.security.SecureRandom;

public class RollDie {
   public static void main(String[] args) {
      SecureRandom randomNumbers = new SecureRandom(); 
     /* Create an array for counting the frequencies of a six-sided roll. Assume that the index of the array will store the frequencies of each side starting from 1  */ // array of frequency counters

      // roll die 600,000 times; use die value as frequency index
      for (;; /* Complete the required for header */) {
         /* Increase the the counter of frequencies according to the output of the invoking randomNumbers.nextInt(6)  */
      }

      System.out.printf("%s%10s%n", "Face", "Frequency");
   
      // output each array element's value
      for (;; /* Complete the required for header */) {
         System.out.printf("%4d%10d%n", /* Print the face number of the die */, /* Print the frequency of rolling that face in the 600,000 trials  */);
      } 
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
