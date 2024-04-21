// Fig. 7.9: AccountTest.java
// Inputting and outputting floating-point numbers with Account objects.
import java.util.Scanner;

public class AccountTest {
   public static void main(String[] args) {
      /* Create an instance of the class Account "account1" with valid name and balance values */
      /* Create an instance of the class Account "account2" with valid name but invalid balance values */

      // display initial balance of each object
      System.out.printf("%s balance: $%.2f%n",
         /* Call the method "getName"  from account1 */, /* Call the method "getBalance"  from account1 */); 
      System.out.printf("%s balance: $%.2f%n%n",
         /* Call the method "getName"  from account2 */, /* Call the method "getBalance"  from account2 */); 

      // create a Scanner to obtain input from the command window
      Scanner input = new Scanner(System.in);

      System.out.print("Enter deposit amount for account1: "); // prompt
      double depositAmount = input.nextDouble(); // obtain user input
      System.out.printf("%nadding %.2f to account1 balance%n%n", 
         depositAmount);
      /* Call the method deposit of "account1" passing the value read from the scanner as argument */ // add to account1's balance

      // display balances
      System.out.printf("%s balance: $%.2f%n",
         /* Call the method "getName"  from account1 */, /* Call the method "getBalance"  from account1 */); 
      System.out.printf("%s balance: $%.2f%n%n",
         /* Call the method "getName"  from account2 */, /* Call the method "getBalance"  from account2 */); 

      System.out.print("Enter deposit amount for account2: "); // prompt
      depositAmount = input.nextDouble(); // obtain user input
      System.out.printf("%nadding %.2f to account2 balance%n%n", 
         depositAmount);
      /* Call the method deposit of "account2" passing the value read from the scanner as argument */ // add to account2 balance

      // display balances
      System.out.printf("%s balance: $%.2f%n", 
         /* Call the method "getName"  from account1 */, /* Call the method "getBalance"  from account1 */); 
      System.out.printf("%s balance: $%.2f%n%n",
         /* Call the method "getName"  from account2 */, /* Call the method "getBalance"  from account2 */); 
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
