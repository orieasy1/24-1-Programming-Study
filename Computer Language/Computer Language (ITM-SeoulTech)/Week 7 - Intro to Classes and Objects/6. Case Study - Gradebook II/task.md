# Case Study: Class `GradeBook` Using a Two-dimensional Array

In the last task, we presented class `GradeBook` (Fig. 7.14), which used a one-dimensional
array to store student grades on a single exam. 

In most semesters, students take several exams. Professors are likely to want to analyze grades 
across the entire semester, both for a single student and for the class as a whole.

# Storing Student Grades in a Two-Dimensional Array in Class `GradeBook`

Figure 7.16 contains a `GradeBook` class that uses a two-dimensional array grades to store the
grades of several students on multiple exams. Each row of the array represents a single student’s
grades for the entire course, and each column represents the grades of all the students who
took a particular exam. 

Class `GradeBookTest` (Fig. 7.17) passes the array as an argument to
the `GradeBook` constructor. 

In this example, we use a ten-by-three array for ten students’
grades on three exams. Five methods perform array manipulations to process the grades.


Each method is similar to its counterpart in the earlier one-dimensional array version of
`GradeBook` (Fig. 7.14):

1. Method `getMinimum` (lines 39–55 of Fig. 7.16) determines the lowest 
grade of any student for the semester. 
2. Method `getMaximum` (lines 58–74) determines the highest grade of any student for the semester. 
3. Method `getAverage` (lines 77–87) determines a particular student’s semester average. 
4. Method `outputBarChart` (lines 90–121) outputs a grade bar chart for the entire semester’s student grades. 
5. Method `outputGrades` (lines 124– 148) outputs the array in a tabular format, along with each student’s semester average.