package day2;

import java.util.Scanner;

public class prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        // Check for division by zero
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero!");
        } else {
            double result = num1 / num2;
            System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
        }
        
        sc.close();
    }
}
