# Computer Language Week 10

## Class and Objects: A Deeper Look

* throw exception
* this: overloaded constructor
* enum type

### Inroduction to Object Techonology

* Objects(the classes objects come from) are essentially resuable software componets.
    * Almost any noun can be reasonably represented as a software object in term of attributes 속성(필드), and behaviors 기능(메소드).
* modular, object-oriented design and implementation approach to be much more productive than structured programming(earlier popular technigues).
* object-oriented programs are often easier to undrestand, correct and modify.
<br>

**자동차로 이해하는 OOP**

1. 자동차와 객체
    * 자동차는 복합한 메커니즘의 집합체이다. 이를 객체라고 볼 수 있다.
    * 자동차 객체는 가속 페달, 브레이크 페달, 핸들 등의 속성과 이를 조작하는 메서드를 가질 수 있다.
        * make it go faster by pressing its accelerator pedal
    * 자동차는 도면을 부터 디자인된다. 객체 지향 프로그래밍에서 설계를 담고 있는 도면을 클래스라고 한다. 클래스로부터 생성된 객체를 인스턴스라고 한다.
        * before you drive a car it must be built from the engineering drawings that discribe it.
    * 페달은 자동차 속도를 증가시키는 복잡한 메커니즘을 가지고 있지만 이를 신경쓰지 않고도 간단하게 속도를 조절할 수 있도록한다. 이는 캡슐화와 정보은닉의 예이다.
        * pedal hides from the driver the complext mechanisms that actually make the car to go faster.
        * brake pedal hides the mechanisms that slow the car
        * the steering wheel hides the mechanisms that turn the car.

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


### Overloded Constructor

Every object can access a reference to itself with keyword this.
Can use this reference implicitly and explicitly.

Overloaded Consturctuors enable objects of a class to be initialized in different ways.
To overload constructors, sitmply provide multiple constructor declarations with different signatures.
Recall that the complier differentiates signatures by the number of parameter types in each signature.

