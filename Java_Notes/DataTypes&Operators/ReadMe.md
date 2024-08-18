# Data Types & Operators

- Relations
* Aggregation
* Composition

Relations between Classes
-------------------------
Composition --> Has-A
- Full ownership and life time started with object container 
- ex:Let's consider an example of a Car class that uses an Engine class. A car "has an" engine, so the car class will have an instance of the engine class.

Aggregation --> It represents a "has-a" relationship, similar to composition, but with a weaker bond,an object is composed of one or more objects, but these objects have an independent lifecycle.
-Partial ownership with sperated lifetime
-Ex: Let's consider an example of a Department class that uses an Employee class. A department "has" employees, but employees can exist without the department (e.g., they could move to another department).

Association Use-A
-No Ownership but it method use a refernece to another class

* If we have a shape classes and another class is picture this class has method called draw which take 3 arrays (Rectangle - Circles - Triangles)
* So what type of relationship --> no ownership so it's Uses-A (Association)
but what if I have instance member reference and we **allocate it by some method and a refernece point to them** so it's aggregation
* **Creation happens inside class container** so it's Composition because lifetime is attached together.


- We judge on it based on Ownership and lifetime Object from class that has reference to another class and they are created together

- Aggregation
* it will be sent to me and I have a reference to it 
Association
------------------------------------------------------------------------------------------------

# Identifier
================
- Identifier is a name given to a variable, function, class, etc.
- Identifier can be a combination of letters, digits, and underscores
- Identifier cannot start with a digit or reserved keyword

* Data Types ---> 1) Primitive            2) Reference

* Characters are unsigned Unicode chars and they are 2B.
- For each primitive has corresponding class which means data and methods.

- Primitive types are immutable and they are passed by value.
- Reference types are mutable and they are passed by reference.

* What are Wrappers
- Wrappers are classes that wrap primitive types and provide additional functionality.
- Wrappers are mutable and they are passed by reference.
```jave
class wrappers{
    public static void main(String[] args) {
        Integer i = new Integer(5); // --> == Integer i = 5 ;
        int pi = i; //Auto outboxing operation
        i = 10 ; //Auto inboxing --> This only for Wrappers
        System.out.println("pi: "+pi);
    }
}
```
**What are Boxing and Unboxing**
- Boxing is the process of converting a primitive type to its corresponding wrapper class.
- Unboxing is the process of converting a wrapper class to its corresponding primitive type.
- Boxing and unboxing are done automatically by the Java compiler and only done for wrapper classes (Integer, Double, Float, etc.)

**Top parent for all classes in Java is Object**
- Object class is the topmost class in Java.
- All classes in Java are subclasses of Object class.
- Any class by default extend functionality from Object class that has group of methods to be inhereted by default


* 017 --> Compiler understands this as Octal representation
* 0x17 --> Hexa
------------------------------------------------------------------------------------------------
* From small data type to larger --> Implicit Casting
* From larger data type to smaller --> Explicit Casting

* instanceof 
- It is used to check whether an object is an instance of a particular class or not.
- It returns true if the object is an instance of the class, otherwise it returns false.

* unsigned right shift
- It is used to shift the bits of a number to the right.
- It shifts the bits of the number to the right and fills 0 on voids left as

------------------------------------------------------------------------------------------------
# Reference Types 

- Reference types are classes, interfaces, arrays, and enumerations.
- **Reference is allocated in stack BY default but could be in heap and the object is -ALWAYS- allocated in heap.**
- Reference is a pointer to the object.
- Reference is used to access the object.

**An Object is garbage collected when there is no reference pointing to it.**

```jave
Myclass myRef;    // just a Null reference
myRef = new Myclass //Construct a new object
```
* Can I enforce garbage collector to work? 
--> I can only request maybe accept or not but I can't enforce him.

* How can i request? 
--> System.gc

**Garbage collector**
- Garbage collector is a part of JVM and run by it.
- Garbage collector is responsible for freeing the memory occupied by the objects that are no longer in use. Freeing mean that will release the resource to heap manager.

------------------------------------------------------------------------------------------------
# What is Array?
--> Array is a reference type not data structure
 * Could be made with the same family, Like classes inherited from Parent.
**Syntax**
```java
dataType[] arrayName = new dataType[arraySize];
```
or Hard copied
```java
dataType[] arrayName = {value1, value2, value3, value4};
```
- Previously we mentioned that **Reference is allocated in stack BY default but could be in heap** --> So the case is here 
```java
String[] namesArr = new String(3); //here there is namesArr is located in Stack but the array of reference is located at Heap and points to objects in heap outside array
```
**The Island Problem**
--> The island problem is a problem in which an object is referenced by an array but the array is not referenced by any other object. In this case, the object will be garbage collected.

------------------------------------------------------------------------------------------------
# Strings
- Object of class String are immutable because of the fixed size, So we we concatenate on the previous String it creates new Object of the previous value and add the new part, then assign previous reference to new object and then the Grabage collector delete the previous Object. 

- String Objects that are created without new is different than only assigning
```java
String[] arr1 = new String("Ahmed"); // here will create two objects called ahmed
String[] arr2 = new String("Ahmed");

String[] s1 = "Welcome" // here will store it at String pool in heap which is a special place for Strings
String[] s2 = "Welcome" // Will search for Welcome so he will find it then will point to same place

s1 += "World" // Here it will create new object and assign world to welcome so s1 will only point to welcome World but s2 still points to welcome
System.out.print(s2); // Will print welcome 
```
------------------------------------------------------------------------------------------------
**PS Notes**
- You can create a reference from an Abstract class but u cannot create Object.
                
- DON'T COMPARISE two references by IS EQUEL(==) it will shallow comparison, because we only have one case that reference will be equel, When they points to same object. 
                
- You can Compare between the instance methods. So you comparise objects by Objects.equel(object2).

- NO OPERATORS OVERLOADING is available not Like C++.


