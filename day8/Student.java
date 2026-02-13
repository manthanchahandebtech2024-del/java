import java.util.ArrayList;
import java.util.List;

// --- 1. Student Class ---
class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public void displayStudentDetails() {
        System.out.println("Student: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average Grade: %.2f\n", calculateAverage());
        System.out.println("-----------------------------");
    }

    public String getName() {
        return name;
    }
}

// --- 2. GradeManager Class ---
class GradeManager {
    private List<Student> students;

    public GradeManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student.getName());
    }

    public Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        System.out.println("\n--- All Student Records ---");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student s : students) {
                s.displayStudentDetails();
            }
        }
    }
}

// --- 3. Main Class ---
public class Main {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();

        // Adding students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        manager.addStudent(s1);
        manager.addStudent(s2);

        // Adding grades to Alice
        s1.addGrade(85.5);
        s1.addGrade(90.0);
        s1.addGrade(78.0);

        // Adding grades to Bob
        s2.addGrade(92.0);
        s2.addGrade(88.5);

        // Display all students to show averages
        manager.displayAllStudents();

        // Demonstrating searching for a student
        String searchName = "Alice";
        System.out.println("Searching for " + searchName + "...");
        Student found = manager.findStudentByName(searchName);
        
        if (found != null) {
            System.out.println("Found Record:");
            found.displayStudentDetails();
        } else {
            System.out.println("Student not found.");
        }
    }
}