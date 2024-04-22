# Using Command-Line Arguments

It’s possible to pass arguments from the command line to an application via method main’s
`String[]` parameter, which receives an array of Strings. 

By convention, this parameter is named `args`. 

* When an application is executed using the java command, Java passes the
command-line arguments that appear after the class name in the java command to the
application’s main method as Strings in the array `args`. 
* The number of command-line arguments is obtained by accessing the array’s length attribute. 
* Common uses of command-line arguments include passing options and filenames to applications.