// Fig. 6.12: InitArray.java
// Initializing two-dimensional arrays.

public class InitArray {
   // create and output two-dimensional arrays
   public static void main(String[] args) {
      /* Declare a two-dimensional array with an array initializer.\n The first element should be an array with values [1,2,3]. The second element\n should be an array with values [4,5,6] */  
      /* Declare a second two-dimensional array with an array initializer.\n The first element should be an array with values [1,2]. The second element \n should be an array with values [3] and the third element should be an array\n ith values [4,5,6] */

      System.out.println("Values in array1 by row are");
      /* Invoke the method outputArray passing the first array that you created as argument */ // displays array1 by row
   
      System.out.printf("%nValues in array2 by row are%n");
      /* Invoke the method outputArray passing the second array that you created as argument */ // displays array2 by row
   } 

   // output rows and columns of a two-dimensional array
   public static void outputArray(int[][] array) {
      // loop through array's rows                                   
      for (/* Complete the header of the required for statement */) {                 
         // loop through columns of current row                      
         for (/* Complete the header of the nested for statement*/) {
            System.out.printf("%d  ", /* Write the statement that access an element for a two-dimensional array. Use the right order for rows and columns counters */);           
         }                                                           
                                                                     
         System.out.println();                                       
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
