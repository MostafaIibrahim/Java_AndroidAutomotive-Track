# What is OOP
================
Object-Oriented Programming (OOP) is a programming paradigm that revolves around the concept of objects, mapping Real World to SW.
and classes. It's a way of designing and organizing code to make it more modular, reusable,
and maintainable.
### Key Concepts
- **Class**: A blueprint or template that defines the properties and behavior of an object.
- **Object**: An instance of a class, with its own set of attributes (data) and methods (functions).


### Encapsulation**: The idea of bundling data and methods that operate on that data within a single unit, called a class or object.

### Syntax of Class in JAVA
```java
<access-modifier>* class<name>{
    <attributeDeclaration>*
    <methodDec>*
    <ConstructorDec>*
}
```
- The object of data-hiding --> To protect Data from miss use by validating in getters and setters and it's way to put constrains.

- **Rules** :
- Any methods take parameters, We must check on these parameters

- Have a try with **Codility website**  to practice coding skills

- **Practice** : 
```jave
class SerratedDisc{
    private static void myMethod(){
        System.out.println("Hello");
    }
}

- **Constructor** --> Initialize instance member variables
- Objects in Java [دئما و ابداااا] in Heap section, All variables are Dynamically allocated.
- To Initialize a variable:
```java
SerratedDisc disc1; //Reference
disc1 = new SerratedDisc(); //Object
```

- Could any Constructor be private--> Yes we could to control the creation of any Object.
- We don't have Destructor

- Data and Functions could be called as Members
**Members** Divided to two types
1. Instance Memebers 
2. Class Members
- **Instance Members** :
1. It's an attribute of the object that differentiate between different objects
2. Accessed by the Object
3. Exist in memory when the object is created
4. Exist in memory by number of created objects if this member was a variable but methods are created only once
5. This reference is sent to instance member methods **only!!!**
ex
```java
disc1.setSize(disc1,5) //disc1 is sent implicitly to access the right Object.
disc2.setSize(disc2,10)
```
- **This Reference**: It's the reference to the current instance of the class.
- **As long as I didn't mention Static identifier so it'snot Static so it could be sent this to her**
- Shadowing operation 

- **Class/Static Members** : 
1. It's an attribute of the class that differentiate between different classes[يعنى صفة للكاتيجوري كله يعنى كل الاوبجكت اللى جوه ليها نفس الصفة دى], and this is what is meant by class/static members
2. Accessed by the name of Class, [بطريقة جربتها و نفعة]could by name of Object --> But bad practice to access using object.
3. Exist in memory when the class is loaded
4. Created Only once
5. Static Members don't have **this reference**
6. Static Members are shared between all objects of the class
7. Static Members are created when the class is loaded

- **Constructor cannot be static because it has this reference and initializa instance members so it's instance member**
- singleton design pattern:is a software design pattern that restricts the instantiation of a class to a singular instance.
```java

public static serratedDisc create(){
    if(disc == null)
        disc= new serratedDisc();
    return disc
}
```
------------------------------------------------------------------------------------------------
### Inheritance: The process by which one class can inherit the properties and behavior of another class
- Is to extend the functionality of existing class
- **Side Note**
- **Obfuscator:Obfiscation which is shuffle the code in a vay that JVM can deal with it as encryption to protect the code from reverse engineering process + Reduce footprint of the code**,but level of difficulty could destroy all work
- **Decompiler is the tool which used to reverse engineer compiled code**

- That's why we need to inheritence cuz we don't have source code always.

- **How to think in Inheritence**
1. Generalization is the way of thinking from bottom to upper layer such as u start thinking from child class to parent class.
2. specialization is the way of thinking from upper to bottom layer such as start thinking from parent to child

- So Inheritence should achieve two conditions which are
1. **IS-A**: The child class is a type of parent class
2. Hierarchy: between siblings

---> **لازم نشترك فى معظم الصفات و نختلف فى القليل اللى هى حتة التخصص**  <--------

- **How it happends in Java**
- By using keyword extend.

**When we create an object from a child class, the parent class's object is first created using the default constructor by default**, It's Important to be by default but if I wrote it, I should make sure that it's public.
* So it means that the parent created object of parent using default constructor by default then construct around it child object.

### Use case 
1. in Java what if I want to call defualt constructor of child but I have only parameterized constructor in the parent.
```java
public Child(){
    super(0,0); // Constructor redirection **Should be first statment
    system.out.println("Child class constructor");
}
```
- We don't have in Java
```java
public Child():Parent(5,10){
     // Not allowed 
}
```
2. if I sent to child in main Child(5,10,20); , Parent only have
```java
public int sum(int n1 , int n2 , int n3){
    return this.n1 + super.n2 + super.n3;
}
```
So Super has two functionality as a reference and as a function(Constructor redirection).
- **Super is a reference to the parent class**
- **Super is a function to call the parent class constructor and it MUST be first statment**
------------------------------------------------------------------------------------------------
### Polymorphism: The ability of an object to take on multiple forms, depending on the context in which it is used. Give to user EASE of use.

- **Application of Polymorphism**
1. **Method Overloading**: The apperence of method with same name and different parameterized list more than one time in **Within class scope** the same class or more than classes have Inheritence between them.

**Retrun type is not a signeture**
```java
public void add(int a , double b){}
public int add( int a ,double b ){}
int x = add(10,5.5); //Not allowed
```

2. **Method Overriding**: The apperence of Method with the complete signture **(Starting from modifier till before the first bracket)** within more than class has inheritence between them.
- This Give Specialization

3. Reference from Parent point to object from child
```java 
Parent p = new Child(); // P will look to only mutual members between them
p.setNo1(1);
p.setNo2(2);
p.sum();
```
- In Compilation --> Compiler will check as a text, that everything exist, that check if p has member called setNo1,2, sum --> Successfull.
- In run tiime --> Depend on the object we will make late binding which will link to object member.
- **Late Binding** is the process of linking the method call to the method at runtime.

- Java works in dynamic/late binding which is linking in runtime that's why Java don't have virtual Keyword but her effect exists because all of them are Virtual bu default.

### Here we complete the real meaning of extension and Polymorphism which helps me to create a generic function.