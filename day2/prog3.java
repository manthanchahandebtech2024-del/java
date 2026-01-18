package day2;

public class prog3 {
    
    // To accept two float parameters and returns double
    public static double addNumbers(float num1, float num2) {
        // Converting float to double and performing addition
        double result = (double)num1 + (double)num2;
        return result;
    }
    
    public static void main(String[] args) {
        float a = 10.5f;
        float b = 20.3f;
        
        // Pass float variables to function and get result as double
        double sum = addNumbers(a, b);
        
        // Display the result
        System.out.println("First number (float): " + a);
        System.out.println("Second number (float): " + b);
        System.out.println("Sum (double): " + sum);
    }
}
