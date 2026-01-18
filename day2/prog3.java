package day2;

import java.util.Scanner;

public class prog3 {
    
    // Function to add two float numbers and return result as double
    public static double addNumbers(float num1, float num2) {
        return (double) (num1 + num2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number (float): ");
        float firstNum = sc.nextFloat();
        
        System.out.print("Enter second number (float): ");
        float secondNum = sc.nextFloat();
        
        // Call function and store result in double
        double result = addNumbers(firstNum, secondNum);
        
        System.out.println("Addition result: " + firstNum + " + " + secondNum + " = " + result);
        
        sc.close();
    }
}
