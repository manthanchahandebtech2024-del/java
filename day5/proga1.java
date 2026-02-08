final class Student {
    private final String studentId;
    private final String name;
    private int marks;
    
    // Constructor to initialize final variables
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.marks = 0;
    }
    
    // Final method - Cannot be overridden in subclass
    public final void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
    
    // Regular method - Can be overridden (if class wasn't final)
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
    public int getMarks() {
        return marks;
    }
}

// Regular class to demonstrate final variable
class FinalVariableDemo {
    
    public static void main(String[] args) {
        System.out.println("===== FINAL CLASS, FINAL METHOD, AND FINAL VARIABLE DEMO =====\n");
        
        // Creating object of final class Student
        Student student1 = new Student("S001", "Alice");
        student1.setMarks(85);
        
        Student student2 = new Student("S002", "Bob");
        student2.setMarks(92);
        
        // Calling final method
        System.out.println("Student 1 Information:");
        student1.displayInfo();
        
        System.out.println("\nStudent 2 Information:");
        student2.displayInfo();
        
        // Demonstrating final variable
        System.out.println("\n===== FINAL VARIABLE DEMONSTRATION =====");
        final int maxMarks = 100;  // Final variable
        System.out.println("Maximum Marks (Final Variable): " + maxMarks);
        
        // Attempting to modify final variable will cause compilation error
        // maxMarks = 150;  // Error: Cannot assign a value to final variable maxMarks
        
        // Final variable with object reference
        final Student student3 = new Student("S003", "Charlie");
        System.out.println("\nFinal object reference (cannot reassign to different object):");
        student3.setMarks(88);
        student3.displayInfo();
        
        // Below line will cause compilation error:
        // student3 = new Student("S004", "David");  // Error: Cannot reassign final variable
        
        // But we CAN modify the properties of the object
        student3.setMarks(95);
        System.out.println("\nAfter modifying marks of final object reference:");
        student3.displayInfo();
        
        System.out.println("\n===== KEY POINTS =====");
        System.out.println("1. Final Class: Student class cannot be extended/inherited");
        System.out.println("2. Final Method: displayInfo() method cannot be overridden");
        System.out.println("3. Final Variable: studentId, name (and maxMarks) cannot be modified");
        System.out.println("4. Final object reference: Cannot be reassigned, but properties can be modified");
    }
}

/* 
NOTE: 
- Student is a FINAL CLASS - cannot be inherited
- displayInfo() is a FINAL METHOD - cannot be overridden
- studentId, name in Student class are FINAL VARIABLES - cannot be changed
- maxMarks in main is a FINAL VARIABLE - cannot be changed
- student3 is a FINAL REFERENCE - cannot point to another object
*/
