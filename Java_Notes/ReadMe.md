# Exception Handling

### Exceptions --> An object that's created when abnormal situation arises in your program during runtime / unexpected behavior happened during runtime

- Two Scenarios
    - due to wrong implementation of developer
    - due to external factors (e.g. network failure, user input)

- Exception is an object has description about nature of the problem so this exception is thrown and I should handle this problem, It is thrown by the code and caught by the code and then handled by the code

- Throwable class divided into two types
    1. Error --> cannot be handled (out of memory)
    2. Exception --> can be handled. It's divided to two types
        2.1) Checked exceptions --> NOT DEVELOPER MISTAKE 
        2.2) RunTimeException --> Mistake of developer
    - if I used a method that throw Checked exceptions in java it will stop compilation until I provide exception handlers
### So If not handeled Checked exception then it will Stop Compilation , Inherit from Exception directly

- **NEVER EVER HANDEL unchecked exceptions** like don't handle NullPointerException.

- How to Implement Exception Handling? 
1.  - **try** block --> try if there is an exeception or not 
    - **catch** block --> catch exception to handle it
    - **finally** block --> This part is always run with exception or not, Not always used but it could be used 

- **Don't leave an empty catch** because it will hide the exception and you will not know
- **Don't handle exception in finally** because it will be executed even if exception is not thrown


2. **throw** keyword
```java
public void testMethod() throws XYZException{ //Call compiler that this function may have an exception
...
if (n < length){
    throw new EOFException(); //throw the exception
return s ;
}
}
```
- **So who ever call my method will handle the problem**, it propagades the problem to another level.
- Throw is in signeture of the method so it could be overloaded

2. Catch exception and through another exception

### Important Note
- Don't use several try - catch separatly cuz it will Stop the program to try and catch then it will slow down the process.

* So u might use one try and several catches. 
* If u don't care about the exception type then u could write one try and one catch.

### If you try to catch an error inherit from another error class, Then you should handle the child first
 * Why? --> Because while Compiling, Compiler will invoke an exception of type parent then when catching it, u should catch exception of parent. If it was from child --> **It will be compilation error**. At Runtime a late binding occurs and go to child exception

 * Opening and closing files
 ------------------------------------------------------------------------------------------------