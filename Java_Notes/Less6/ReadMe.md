# Modifiers-Access Specifiers [ Notes ]
- Public 
    - class means that it could be used outside the package scope and it's only one public class in the file
    - Accessible anywhere
- Private
    -  It's only accessed inside the class
- Protected  
    - It's Accessible inside the class and through inheritence and within the package that the class was defined in.
    - Packaga
    - Inheritence
- Default 
    - It's accessible inside the class and within the package that the class was defined in.
    - Static
    - Package level
- Static 
    - It's a class level variable or method
    - Static method might be called as utility method 
    * Utility method: A method that can be used by any class in the program. It is a method that does not depend on any instance of a class and does not modify the state of the class. 
- Abstract 
    - Class that cannot create from it an instance
    - Class that may contain zero or more abstract method
- Final
    - Last version of the class so it means we **cannot inherit this class**
    - We can't override the method of the final class
    - We can't change the final variable only one value
    - **And it's the opposite idea of Abstract**
- Native
    - it's only with methods 
    - It's a method that is implemented in the native code of the platform like if I work with windows  so we can write in C/C++
- lock in Java with threads (Aquire resource) 
    * Volatile for variables 
    * Synchronized for methods
- Transient
    * Hypernat for Object like save the state of the object and convert it to array of files so it could be written on file or sent to another network or whatever so this method called serialization --> Conver object to bytes.
    * So Transient used to prevent the serialization of the variable 
    * So if I want to do Serialization for an object and a member variable that I don't want to be included in the Serialization process so we initialize it to be Transient.


- **Free Floating Block / Static Initializer--> A Block of code that is written in memory as soon as the class exist in the memory**
    - Syntax of it 
    ```java
    class Myclass{
        private static int x ;
        static {
            // code here
            x = 5 + 6 ;
            }
    }
    ```
- So, As soon as class appears in memory, it automatically initialize in memory directly

* I can import public class such as 
    import package1.A == Class D extends package1.A{} --> Fully qualified class name
    and If I used second term I should always use with same name


- drawOval() --> Takes upper left corner of tangent rectangle and width and height
- Final Reference -> **It's a reference that can't be changed to point to another object**

* Rule --> When I have a variable that have uncalculated value --> Directly u should know that u will find final static variable that express what I want, Find it in decumentation.

- When you deal with a class that is Abstracted and you want to use this class but u cannot create an object of it so directly u will find inside this a **public static method that returns object of her child class**
ex: we have method called getFontList() --> This is instance method and this is abstrace so in the same class search for something that returns child 

1. look for the class u will find it abstracted 
2. Search for public static method 
3. call it to get an object and through this object call ur methods.

- When u find Depreecated beside a method so it means that this is old and there is something newer.

-------------------------------------------------------------------------------------------------
 