# Java Learning Journey

Welcome to this Java learning repository! It is organized as a day-by-day course that starts from the absolute basics and builds up to real-world object-oriented programming (OOP) applications. Each folder contains working Java programs that illustrate the concept taught that day.

---

## Table of Contents

1. [Day 1 – Hello World & Variables](#day-1--hello-world--variables)
2. [Day 2 – User Input, Methods, Inheritance & Strings](#day-2--user-input-methods-inheritance--strings)
3. [Day 4 – Classes, Objects & Command-Line Arguments](#day-4--classes-objects--command-line-arguments)
4. [Day 5 – Abstract Classes, Interfaces & the `final` Keyword](#day-5--abstract-classes-interfaces--the-final-keyword)
5. [Day 7 – Arrays, Collections, Strings, Polymorphism & Exceptions](#day-7--arrays-collections-strings-polymorphism--exceptions)
6. [Day 8 – Practical OOP Applications](#day-8--practical-oop-applications)
7. [How to Compile and Run](#how-to-compile-and-run)

---

## Day 1 – Hello World & Variables

**Files:** `day1/Helloworld.java`, `day1/prog1.java`

### 1.1 Hello World

The simplest Java program — it prints a message to the screen.

```java
public class Helloworld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Key Points:**
- Every Java program needs a `public class` whose name matches the filename.
- Execution starts at `public static void main(String[] args)`.
- `System.out.println()` prints a line followed by a newline.

### 1.2 Variables & Data Types

Java is **statically typed** — you must declare the type of every variable.

```java
String name    = "Manthan";       // text
int    roll_no = 105;             // whole number
String address = "Sus Road, Pune"; // text
```

| Type      | Size    | Example value |
|-----------|---------|---------------|
| `int`     | 32-bit  | `105`         |
| `long`    | 64-bit  | `24070122105L`|
| `double`  | 64-bit  | `3.14`        |
| `float`   | 32-bit  | `10.5f`       |
| `boolean` | 1-bit   | `true`        |
| `String`  | object  | `"Hello"`     |

---

## Day 2 – User Input, Methods, Inheritance & Strings

**Files:** `day2/prog1.java` – `day2/prog5.java`, `day2/today2.java`

### 2.1 Reading User Input with `Scanner`

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
double num1 = sc.nextDouble();
double num2 = sc.nextDouble();

if (num2 == 0) {
    System.out.println("Error: Cannot divide by zero!");
} else {
    System.out.println("Result: " + (num1 / num2));
}
sc.close();
```

**Key Points:**
- Import `java.util.Scanner` to read input from the keyboard.
- Always close the scanner with `sc.close()` when done.
- Guard against division by zero with an `if` check.

### 2.2 Methods & Type Casting

Methods let you reuse blocks of code. Java allows you to **cast** one numeric type to another.

```java
// Method that accepts two floats but returns a double
public static double addNumbers(float num1, float num2) {
    double result = (double)num1 + (double)num2; // explicit cast
    return result;
}
```

**Key Points:**
- `(double)num1` is an **explicit cast** — it widens a `float` to a `double`.
- `static` methods belong to the class itself and can be called without creating an object.
- The return type (`double`) must match the value returned.

### 2.3 Inheritance

A **child class** extends a **parent class** and inherits its fields and methods.

```java
class Parent {
    String name;
    int age;

    Parent(String name, int age) {   // constructor
        this.name = name;
        this.age  = age;
    }

    void displayParentInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Child extends Parent {
    String school;

    Child(String name, int age, String school) {
        super(name, age);        // calls Parent's constructor
        this.school = school;
    }

    void displayChildInfo() {
        displayParentInfo();     // reuse parent method
        System.out.println("School: " + school);
    }
}
```

**Key Points:**
- Use the `extends` keyword to create a subclass.
- `super(...)` calls the parent class constructor — it must be the **first** statement in the child constructor.
- `this` refers to the current object.

### 2.4 String Reversal

Two approaches to reversing a string:

```java
// Method 1 – using the built-in StringBuilder
String reversed = new StringBuilder(original).reverse().toString();

// Method 2 – manual loop
String reversed = "";
for (int i = original.length() - 1; i >= 0; i--) {
    reversed += original.charAt(i);
}
```

**Key Points:**
- `StringBuilder.reverse()` is the idiomatic Java way.
- `charAt(i)` returns the character at position `i`.
- String concatenation in a loop (`+= char`) works but is slow for large strings; prefer `StringBuilder` for performance.

### 2.5 The `final` Keyword on Methods

A method declared `final` **cannot be overridden** in a subclass.

```java
class Parent {
    final void display() {
        System.out.println("Final method in Parent class.");
    }
}
// Any attempt to override display() in a subclass causes a compile error.
```

---

## Day 4 – Classes, Objects & Command-Line Arguments

**Files:** `day4/MultipleClassesExample.java`, `day4/CollegeApp.java`

### 4.1 Multiple Classes & Objects

A single `.java` file can contain multiple classes (only one may be `public`).

```java
class Student  { String name = "Rahul"; }
class Academic { int rollNo = 12; }
class Identity { long prn   = 24070122105L; }

public class MultipleClassesExample {
    public static void main(String[] args) {
        Student  s1 = new Student();
        Academic a1 = new Academic();
        Identity i1 = new Identity();

        System.out.println("Name: "    + s1.name);
        System.out.println("Roll No: " + a1.rollNo);
        System.out.println("PRN: "     + i1.prn);
    }
}
```

**Key Points:**
- `new ClassName()` creates a new object (instance) on the heap.
- Fields are accessed with the dot operator (`object.field`).

### 4.2 Command-Line Arguments

Pass data to a program when running it from the terminal.

```java
public class CollegeApp {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java CollegeApp <Name> <RollNo> <PRN>");
            return;
        }
        String name   = args[0];
        int    rollNo = Integer.parseInt(args[1]);  // String → int
        long   prn    = Long.parseLong(args[2]);    // String → long

        StudentInfo obj = new StudentInfo();
        obj.showDetails(name, rollNo, prn);
    }
}
```

**Run it:** `java CollegeApp Manthan 105 24070122105`

**Key Points:**
- `args` is an array of `String` values supplied on the command line.
- `Integer.parseInt()` and `Long.parseLong()` convert strings to numbers.
- Always validate `args.length` before accessing elements.

---

## Day 5 – Abstract Classes, Interfaces & the `final` Keyword

**Files:** `day5/AbstractExample.java`, `day5/AbstractMethodExample.java`, `day5/CalculatorApplication.java`, `day5/Interface.java`, `day5/InterfaceExample.java`, `day5/FinalClassExample.java`, `day5/proga1.java`, `day5/otoday.java`

### 5.1 Abstract Classes

An **abstract class** cannot be instantiated directly. It defines a contract (abstract methods) and may also provide shared concrete behaviour.

```java
abstract class Shape {
    abstract void draw();        // subclasses MUST implement this

    void message() {             // shared concrete method
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

// Usage
Shape s = new Circle();  // polymorphic reference
s.draw();
s.message();
```

**Key Points:**
- Declare with `abstract class ClassName`.
- Abstract methods have no body — they end with `;`.
- A class that `extends` an abstract class **must** implement all abstract methods (or also be abstract).
- You can hold a subclass object in a parent-type variable (`Shape s = new Circle()`).

### 5.2 Calculator Using an Abstract Class

A real-world example that shows why abstract classes are useful:

```java
abstract class Calculator {
    public abstract double add(double a, double b);
    public abstract double subtract(double a, double b);
    public abstract double multiply(double a, double b);
    public abstract double divide(double a, double b);

    // shared helper — not abstract
    public void show(String op, double a, double b, double result) {
        System.out.println(a + " " + op + " " + b + " = " + result);
    }
}

class BasicCalculator extends Calculator {
    public double add(double a, double b)      { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b)   { return (b != 0) ? a / b : 0; }
}

class ScientificCalculator extends Calculator {
    // ... same four methods, plus extras:
    public double power(double base, double exp) { return Math.pow(base, exp); }
    public double sqrt(double num)               { return Math.sqrt(num); }
}
```

**Key Points:**
- Both calculator types share the `show()` helper without code duplication.
- Each type adds its own specialised behaviour on top.
- Polymorphism lets you write `Calculator calc = new BasicCalculator()` and swap implementations easily.

### 5.3 Interfaces

An **interface** is a pure contract — all methods are implicitly `public abstract` (unless declared `default`).

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Woof");
    }
}

Animal myDog = new Dog();
myDog.sound();  // Woof
```

#### Solving the Diamond Problem with Interfaces

Java classes can only inherit from **one** class, but they can **implement many interfaces** — this is how the diamond inheritance problem is resolved.

```java
interface Animal  { void eat(); void sleep(); }
interface Mammal  extends Animal { void walk(); }
interface Bird    extends Animal { void fly(); }

class Bat implements Mammal, Bird {
    public void eat()   { System.out.println("Bat eats insects"); }
    public void sleep() { System.out.println("Bat sleeps during day"); }
    public void walk()  { System.out.println("Bat can crawl"); }
    public void fly()   { System.out.println("Bat flies at night"); }
}
```

**Key Points:**
- Use `implements` (not `extends`) to implement an interface.
- A class can `implement` multiple interfaces separated by commas.
- Every interface method must be given a body in the implementing class.

### 5.4 The `final` Keyword — Three Uses

| Usage | Meaning |
|-------|---------|
| `final class`    | Class cannot be subclassed (e.g., `String`) |
| `final method`   | Method cannot be overridden in a subclass |
| `final variable` | Variable can only be assigned once |

```java
// final class
final class FinalClass {
    void display() { System.out.println("This is a final class"); }
}

// final variable
final int MAX_MARKS = 100;
// MAX_MARKS = 150; // compile error!

// final object reference — the reference is fixed, but object state can change
final Student s = new Student("S001", "Alice");
s.setMarks(95);         // allowed — modifying the object
// s = new Student(...); // compile error — cannot reassign the reference
```

---

## Day 7 – Arrays, Collections, Strings, Polymorphism & Exceptions

**Files:** `day7/ArrayExample.java`, `day7/ArrayListExample.java`, `day7/VectorExample.java`, `day7/StringExample.java`, `day7/StringMethods.java`, `day7/StringTokenizerExample.java`, `day7/TestPolymorphism.java`, `day7/DynamicDispatchDemo.java`, `day7/TryCatchExample.jaav.java`

### 7.1 Arrays

An array is a fixed-size, ordered collection of elements of the **same type**.

```java
int[] numbers = {10, 20, 30, 40, 50};

// Classic for-loop
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// Enhanced for-loop (for-each)
for (int num : numbers) {
    System.out.println(num);
}
```

**Key Points:**
- Array size is fixed at creation time.
- Index starts at `0`; the last element is at `length - 1`.
- Access an out-of-bounds index throws `ArrayIndexOutOfBoundsException`.

### 7.2 ArrayList

`ArrayList` is a **dynamic array** — it grows and shrinks automatically.

```java
import java.util.ArrayList;

ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");

System.out.println(fruits);                       // [Apple, Banana, Cherry]
fruits.remove("Banana");
System.out.println(fruits.get(0));                // Apple
System.out.println("Size: " + fruits.size());     // 2
System.out.println(fruits.contains("Apple"));     // true
```

**Key Points:**
- Use `add()`, `remove()`, `get()`, `size()`, `contains()`.
- Generic type parameter (`<String>`) ensures type safety.
- Backed by a regular array internally — resizes automatically.

### 7.3 Vector

`Vector` is similar to `ArrayList` but is **thread-safe** (synchronized).

```java
import java.util.Vector;

Vector<Integer> numbers = new Vector<>();
numbers.add(100);
numbers.add(200);
numbers.add(300);

numbers.remove(1);                       // removes element at index 1
System.out.println(numbers.get(0));      // 100
System.out.println("Size: " + numbers.size());
```

**Key Points:**
- Prefer `ArrayList` for single-threaded code (faster); use `Vector` or `Collections.synchronizedList()` for multi-threaded scenarios.

### 7.4 Strings

Strings in Java are **immutable objects**.

```java
String str = "Java Programming";

System.out.println(str.length());          // 16
System.out.println(str.toUpperCase());     // JAVA PROGRAMMING
System.out.println(str.trim());            // removes leading/trailing whitespace
System.out.println(str.substring(0, 4));   // Java
System.out.println(str.replace("Java", "Python")); // Python Programming
```

**Key Points:**
- String methods return a **new** string — the original is unchanged.
- Use `new String("text")` or a string literal `"text"` to create strings.
- `StringBuilder` is mutable and faster for repeated modifications.

### 7.5 StringTokenizer

`StringTokenizer` splits a string by delimiters.

```java
import java.util.StringTokenizer;

String str = "Java, Python, C++, JavaScript";
StringTokenizer st = new StringTokenizer(str, ", ");

while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());  // prints each language on its own line
}
```

**Key Points:**
- The second argument lists **delimiter characters** (each character is a delimiter, not the whole string as a unit).
- `hasMoreTokens()` returns `false` when all tokens have been consumed.
- Modern alternative: `str.split(",\\s*")`.

### 7.6 Polymorphism & Method Overriding

**Polymorphism** means the same method call behaves differently depending on the actual object type at runtime.

```java
class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}

Animal a;
a = new Dog(); a.sound();  // Dog barks
a = new Cat(); a.sound();  // Cat meows
```

**Key Points:**
- `@Override` annotation confirms you are overriding a parent method (optional but recommended).
- The decision of which method to call is made **at runtime** based on the object's actual type — this is called **dynamic dispatch**.

### 7.7 Dynamic Dispatch (Upcasting)

```java
class Parent {
    void show() { System.out.println("Parent's show method"); }
}

class Child extends Parent {
    @Override
    void show() { System.out.println("Child's show method"); }
}

Parent childAsParent = new Child();  // upcasting
childAsParent.show();                // prints "Child's show method"
```

**Key Points:**
- **Upcasting** stores a child object in a parent-type variable.
- The JVM resolves which `show()` to call at runtime — this is dynamic dispatch.

### 7.8 Exception Handling with `try-catch`

```java
int num1 = 10, num2 = 0;

try {
    int result = num1 / num2;        // throws ArithmeticException
    System.out.println("Result: " + result);
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero.");
    System.out.println("Exception: " + e.getMessage());
}

System.out.println("Program continues after handling.");
```

**Key Points:**
- Code that might throw is placed in the `try` block.
- The `catch` block handles a specific exception type.
- Execution continues after the `try-catch` block even if an exception occurred.
- Use multiple `catch` blocks to handle different exception types:

```java
try {
    String str = null;
    System.out.println(str.length());  // NullPointerException
} catch (NullPointerException e) {
    System.out.println("Object is null!");
} catch (Exception e) {
    System.out.println("Some other error.");
}
```

---

## Day 8 – Practical OOP Applications

**Files:** `day8/BankAccManagement.java`, `day8/GradeSystem.java`, `day8/LibraryManagement.java`, `day8/OnlineShopping.java`, `day8/TryCatchExample.java`, `day8/MultipleCatchExample.java`

Day 8 brings together everything learned so far in realistic mini-applications.

### 8.1 Custom Exceptions – Bank Account Management

You can create your own exception classes by extending `Exception`.

```java
// Custom exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds!");
        }
        balance -= amount;
    }
}
```

**Key Points:**
- Extend `Exception` for checked exceptions (caller must handle or declare them).
- Use `throw new YourException("message")` to signal a problem.
- Declare that a method may throw with `throws ExceptionType` in the signature.

The full bank demo covers:
- Creating accounts
- Depositing and withdrawing
- Transferring between accounts
- Gracefully handling `InsufficientFundsException`

### 8.2 Grade Management System

Demonstrates `ArrayList` of objects and object-oriented design:

```java
class Student {
    private String name;
    private List<Double> grades = new ArrayList<>();

    public void addGrade(double grade) { grades.add(grade); }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }
}
```

**Key Points:**
- Encapsulate data with `private` fields.
- Expose behaviour through `public` methods.
- `List<Double>` stores a dynamic collection of grades.

### 8.3 Library Management System

Shows how to search a collection of objects:

```java
class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) return book;
        }
        return null;  // not found
    }
}
```

**Key Points:**
- `equalsIgnoreCase()` makes the search case-insensitive.
- Returning `null` when not found is common — always check the result before using it.
- Override `toString()` in your model classes to control how they print.

### 8.4 Online Shopping Cart

Demonstrates removing items from a list using a lambda predicate:

```java
public void removeProduct(String productName) {
    boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
    if (!removed) System.out.println("Product not found.");
}
```

**Key Points:**
- `removeIf(predicate)` safely removes elements while iterating — avoids `ConcurrentModificationException`.
- The lambda `p -> p.getName().equalsIgnoreCase(productName)` is a concise way to write a one-method interface.

---

## How to Compile and Run

### Prerequisites

- Java Development Kit (JDK) 8 or later
- A terminal / command prompt

### Compile

```bash
# From the repository root, compile a specific file
javac day1/Helloworld.java

# Compile all files in a day folder
javac day2/*.java
```

### Run

```bash
# Run a class (no .java extension)
java -cp day1 Helloworld

# Run a program that expects command-line arguments
java -cp day4 CollegeApp Manthan 105 24070122105
```

> **Tip:** Some files use a `package` declaration (e.g., `package day2;`). Compile from the repository root and specify the classpath (`.`) accordingly:
> ```bash
> javac day2/prog2.java
> java -cp . day2.prog2
> ```

---

## Concepts Summary

| Day | Topic |
|-----|-------|
| 1   | Hello World, primitive types, `String` |
| 2   | `Scanner`, type casting, methods, inheritance, `super`, string manipulation, `final` methods |
| 4   | Multiple classes, objects, command-line arguments, `Integer.parseInt` |
| 5   | Abstract classes, abstract methods, interfaces, diamond problem, `final` class/method/variable |
| 7   | Arrays, `ArrayList`, `Vector`, `String` methods, `StringTokenizer`, polymorphism, dynamic dispatch, `try-catch` |
| 8   | Custom exceptions, `throws`/`throw`, encapsulation, practical OOP design patterns |

---

Happy coding! 🚀
