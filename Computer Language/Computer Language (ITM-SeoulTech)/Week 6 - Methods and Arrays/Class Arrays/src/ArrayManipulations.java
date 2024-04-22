// Fig. 6.15: ArrayManipulations.java
// Arrays class methods and System.arraycopy.
/* Import the required library */

public class ArrayManipulations {
   public static void main(String[] args) {
      // sort doubleArray into ascending order
      double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4};
      /* Sort doubleArray */ 
      System.out.printf("%ndoubleArray: ");

      for (/* Complete the enhanced for header for traversing doubleArray*/) {
         System.out.printf("%.1f ", value);
      }

      // fill 10-element array with 7s
      int[] filledIntArray = new int[10]; 
     /* Fill all the elements of filledIntArray with 7's */
      displayArray(filledIntArray, "filledIntArray");

      // copy array intArray into array intArrayCopy
      int[] intArray = {1, 2, 3, 4, 5, 6};
      int[] intArrayCopy = new int[intArray.length];
      System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);
      /* Invoke the method displayArray passing intArray and "intArray" */ as arguments
      /* Invoke the method displayArray passing intArrayCopy and "intArrayCopy"*/ as arguments

      // compare intArray and intArrayCopy for equality
      boolean b = /* Check the equality of intArray and intArrayCopy */
      System.out.printf("%n%nintArray %s intArrayCopy%n", 
         (b ? "==" : "!="));

      // compare intArray and filledIntArray for equality
      b = /* Check the equality of intArray and filledIntArray */
      System.out.printf("intArray %s filledIntArray%n", 
         (b ? "==" : "!="));

      // search intArray for the value 5
      int location = /* Use a binarySearch to locate number 5 in intArray */
      
      if (location >= 0) {
         System.out.printf(
            "Found 5 at element %d in intArray%n", location); 
      } 
      else {
         System.out.println("5 not found in intArray"); 
      } 

      // search intArray for the value 8763
      location = /* Use a binarySearch to locate number 8763 in intArray */

      if (location >= 0) {
         System.out.printf(
            "Found 8763 at element %d in intArray%n", location); 
      } 
      else {
         System.out.println("8763 not found in intArray"); 
      } 
   } 

   // output values in each array
   public static void displayArray(int[] array, String description) {
      System.out.printf("%n%s: ", description);

      for (int value : array) {
         System.out.printf("%d ", value);
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
