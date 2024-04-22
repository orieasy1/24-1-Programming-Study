// Fig. 6.10: PassArray.java
// Passing arrays and individual array elements to methods.

public class PassArray {
   // main creates array and calls modifyArray and modifyElement
   public static void main(String[] args) {
      /* Declare an array and use an array initializer with numbers from */ 1 to 5.
      
      System.out.printf(
         "Effects of passing reference to entire array:%n" +
         "The values of the original array are:%n");

      // output original array elements 
      /* Using an enhanced for statement for printing the original values of the array */
   
     /* Invoke the method modifyArray */ // pass array reference
      System.out.printf("%n%nThe values of the modified array are:%n");

      // output modified array elements 
      /* Print the values of the modified array using an enhanced for statement */
   
      System.out.printf(
         "%n%nEffects of passing array element value:%n" +
         "array[3] before modifyElement: %d%n", array[3]);
   
      /* Invoke the method modifyElement */ // attempt to modify array[3]
      System.out.printf(
         "array[3] after modifyElement: %d%n", array[3]);
   } 
   
   // multiply each element of an array by 2                     
   public static void modifyArray(int[] array2) {                
      /* "Use a for statement (not enhanced) to modify the elements of \n array 2. For example, multiply each element by 2" */                                                         
   }                                                             
   
   // multiply argument by 2                                  
   public static void modifyElement(int element) {            
      /* Modify the value of element by duplicating the original value */                                           
      System.out.printf(                                      
         "Value of element in modifyElement: %d%n", element); 
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
