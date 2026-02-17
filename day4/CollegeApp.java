class StudentInfo {

    // Parameterized method
    void showDetails(String name, int rollNo, long prn) {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("PRN: " + prn);
    }
}

public class CollegeApp {

    public static void main(String[] args) {

        // Check number of command line arguments
        if (args.length != 3) {
            System.out.println("Please enter Name RollNo PRN as command line arguments.");
            return;
        }

        // Taking values from command line
        String name = args[0];
        int rollNo = Integer.parseInt(args[1]);
        long prn = Long.parseLong(args[2]);

        // Creating object of different class
        StudentInfo obj = new StudentInfo();

        // Calling parameterized method
        obj.showDetails(name, rollNo, prn);
    }
}
