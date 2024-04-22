## Passing Arrays to Methods

This section demonstrates how to pass arrays and individual array elements as arguments
to methods. To pass an array argument to a method, specify the name of the array without
any brackets.

## Pass-By-Value vs. Pass-By-Reference

Two ways to pass arguments in method calls in many programming
languages are pass-by-value and pass-by-reference (sometimes called call-by-value and
call-by-reference). 

When an argument is passed by value, a copy of the argument’s value is
passed to the called method. The called method works exclusively with the copy. Changes
to the called method’s copy do not affect the original variable’s value in the caller.

When an argument is passed by reference, the called method can access the argument’s
value in the caller directly and modify that data, if necessary. Pass-by-reference
improves performance by eliminating the need to copy possibly large amounts of data.

Unlike some other languages, Java does not allow you to choose pass-by-value or passby-
reference—all arguments are passed by value.