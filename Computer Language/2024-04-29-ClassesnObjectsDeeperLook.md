# Computer Language Week 10

## Class and Objects: A Deeper Look

### Last week review

* What's the purpose of keyword new? Explain what happens when you use it.

The purpose of keyword new is to create an object of a class.
When keyword new is used in application, first a new object of the class to the right of keyword new is created, then the class's constructor is called to initialize the object.
<br>

* Explain whay a class might provide a set method and a get method for an instance variable.

An instance variable is typically declared private in a class so that only the method of the class in which the instance variable is declared can manipulate it. 

This prevents the variable from being modified accidentally by a class in another part of the program. In some cases, it my be ncessary for an application to modify the private data.
<br><br> 
For example, the owner of a bank account should be able to deposit or withdraw funds an check the account's balance.dkseh 
A class's designer can provide public set and get methods that enable an application to specify the value for  or retrieve the value of a particular object's private instantce variable.

