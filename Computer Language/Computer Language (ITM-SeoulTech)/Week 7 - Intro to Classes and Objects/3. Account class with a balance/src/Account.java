// Fig. 7.8: Account.java
// Account class with a double instance variable balance and a constructor
// and deposit method that perform validation.

public class Account {
   private String name; // instance variable 
   private double balance; // instance variable 

   // Account constructor that receives two parameters  
   /* Create a constructor with two parameters: a name of type String and a balance of type double */ {
      /* Set the instance variable name equal to the parameter name */; // assign name to instance variable name

      // validate that the balance is greater than 0.0; if it's not,
      // instance variable balance keeps its default initial value of 0.0
      /* Validate that the balance is a non-negative number and set the instance variable balance equal to the parameter balance */
   }

   // method that deposits (adds) only a valid amount to the balance
/* Create a public method "deposit" that has a double parameter "depositAmount". The method should validate that the depositAmount is a non-negative number and then increaese the balance of the account accordingly */

   // method returns the account balance
/* Create a method "getBalance" that return the balance of the account */

   // method that sets the name
/* Create a method "setName" that modifies the instance variable name of the account. Set the parameters accordingly */

   // method that returns the name
/* Create a method "getName" that returns the instance variable "name" */
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
