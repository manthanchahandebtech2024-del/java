package day2;

class Parent {
    String name;
    int age;
    
    // Constructor
    Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    void displayParentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Child extends Parent {
    String school;
    
    // Constructor
    Child(String name, int age, String school) {
        super(name, age);  // Call parent constructor
        this.school = school;
    }
    
    void displayChildInfo() {
        displayParentInfo();  
        System.out.println("School: " + school);
    }
}

public class prog4 {
    public static void main(String[] args) {
        Child child = new Child("John", 12, "ABC School");
        
        System.out.println("Child Information:");
        child.displayChildInfo();
    }
}
