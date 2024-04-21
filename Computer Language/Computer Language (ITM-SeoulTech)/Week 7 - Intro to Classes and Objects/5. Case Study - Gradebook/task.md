# Case Study: Class `GradeBook` Using an Array to Store Grades

We now present the first part of our case study on developing a `GradeBook` class that instructors can 
use to maintain students’ grades on an exam and display a grade report that
includes the grades, class average, lowest grade, highest grade and a grade-distribution bar
chart. 

The version of class `GradeBook` presented in this task stores the grades for one
exam in a one-dimensional array. In the next task, we present a version of class `GradeBook`
that uses a two-dimensional array to store students’ grades for several exams.

## Storing Student Grades in an Array in Class `GradeBook`

Class `GradeBook` (Fig. 7.14) uses an array of `int`s to store several students’ grades on a single
exam. Array `grades` is declared as an instance variable (line 6), so each `GradeBook` object
maintains its own set of grades. The constructor (lines 9–12) has two parameters—the name
of the course and an array of grades. When an application (e.g., class `GradeBookTest` in
Fig. 7.15) creates a `GradeBook` object, the application passes an existing int array to the constructor,
which assigns the array’s reference to instance variable grades (Fig. 7.14, line 11).
The grades array’s size is determined by the length instance variable of the constructor’s array parameter.
Thus, a `GradeBook` object can process a variable number of grades. The grade
values could have been input from a user, read from a file on secondary storage, or come from a variety of other sources.
In class `GradeBookTest`, we initialize
an array with grade values (Fig. 7.15, line 7). Once the grades are stored in instance variable
grades of class `GradeBook`, all the class’s methods can access the elements of grades.