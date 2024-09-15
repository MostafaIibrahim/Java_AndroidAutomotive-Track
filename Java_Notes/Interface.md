# Interface Notes

- It's like a protocol to communicate with each other so itnerface talks about behaviuor, so it's just a behviour not the real functionality, it will depend on every class to implement specific behvaior

Interface --->                                             العقد بين الكلاسيس

### So Interface is used to group of abstract classed   ->>>             وكأنها ابستراكت كلاس 
but it's not Abstract class because it has **only Abstracted methods, No concrete class, and it couldnot be Inherited**

Those must be implement

So class can implement more than interface

```java
interface Numbers{
    public int getNext();
    abstract void reset();
    void setStart(int v);
}
```
- In overriding u can widen accessability not norrowing it, I mean u can make a method public and it was friend at parent but u can't do the oposite cuz it's weaker access.

* Reference of Interface can point to an object of class implement this interface --> **Polymorphism concept**.

- **Always divide two phases --> into Compiler process + Runtime process to be able to understand the error**

