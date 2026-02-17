// Class 1
class Student {
    String name = "Rahul";
}

// Class 2
class Academic {
    int rollNo = 12;
}

// Class 3
class Identity {
    long prn = 24070122105L;
}

public class MultipleClassesExample {

    public static void main(String[] args) {

        // Creating 3 different objects
        Student s1 = new Student();
        Academic a1 = new Academic();
        Identity i1 = new Identity();

        // Accessing variables using objects
        System.out.println("Name: " + s1.name);
        System.out.println("Roll No: " + a1.rollNo);
        System.out.println("PRN: " + i1.prn);
    }
}
