# Using Arrays to Analyze Survey Results

Our next example uses arrays to summarize data collected in a survey. Consider the following problem statement:

> *Twenty students were asked to rate on a scale of 1 to 5 the quality of the food in the
student cafeteria, with 1 being “awful” and 5 being “excellent.” Place the 20 responses
in an integer array and determine the frequency of each rating.*


This is a typical array-processing application (Fig. 6.8). 

* We wish to summarize the number of responses of each type (that is, 1–5). 
* Array responses (lines 7–8) is a 20-element integer array containing the students’ survey responses. 
* The last value in the array is intentionally an incorrect response (14). 

 
When a Java program executes, array element indices are checked for validity—all indices must be greater than or equal 
to 0 and less than the length of the array. 

Any attempt to access an element outside that range of indices results
in a runtime error that’s known as an `ArrayIndexOutOfBoundsException`. 