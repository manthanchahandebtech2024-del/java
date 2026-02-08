// Calculator Application using Abstract Class in Java

// Abstract class defining the structure for all calculators
abstract class Calculator {
    
    // Abstract methods - must be implemented by subclasses
    public abstract double add(double num1, double num2);
    public abstract double subtract(double num1, double num2);
    public abstract double multiply(double num1, double num2);
    public abstract double divide(double num1, double num2);
    
    // Concrete method - available to all subclasses
    public void displayResult(String operation, double num1, double num2, double result) {
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }
    
    // Concrete method - helper to check validity
    public boolean isDivisionValid(double divisor) {
        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed!");
            return false;
        }
        return true;
    }
}

// Concrete class implementing Calculator
class BasicCalculator extends Calculator {
    
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    @Override
    public double divide(double num1, double num2) {
        if (isDivisionValid(num2)) {
            return num1 / num2;
        }
        return 0;
    }
}

// Another concrete implementation with additional features
class ScientificCalculator extends Calculator {
    
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }
    
    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    @Override
    public double divide(double num1, double num2) {
        if (isDivisionValid(num2)) {
            return num1 / num2;
        }
        return 0;
    }
    
    // Additional methods specific to Scientific Calculator
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    public double squareRoot(double num) {
        if (num < 0) {
            System.out.println("Error: Cannot calculate square root of negative number!");
            return 0;
        }
        return Math.sqrt(num);
    }
    
    public double percentage(double num, double percent) {
        return (num * percent) / 100;
    }
}

// Main class to demonstrate the calculator application
public class CalculatorApplication {
    
    public static void main(String[] args) {
        System.out.println("========== CALCULATOR APPLICATION USING ABSTRACT CLASS ==========\n");
        
        // Creating object of BasicCalculator
        System.out.println("===== BASIC CALCULATOR =====");
        Calculator basicCalc = new BasicCalculator();
        
        // Testing basic operations
        double result1 = basicCalc.add(15, 8);
        basicCalc.displayResult("+", 15, 8, result1);
        
        double result2 = basicCalc.subtract(20, 7);
        basicCalc.displayResult("-", 20, 7, result2);
        
        double result3 = basicCalc.multiply(6, 9);
        basicCalc.displayResult("*", 6, 9, result3);
        
        double result4 = basicCalc.divide(50, 5);
        basicCalc.displayResult("/", 50, 5, result4);
        
        // Test division by zero
        System.out.print("Testing division by zero: ");
        basicCalc.divide(10, 0);
        
        // Creating object of ScientificCalculator
        System.out.println("\n===== SCIENTIFIC CALCULATOR =====");
        ScientificCalculator sciCalc = new ScientificCalculator();
        
        // Testing basic operations
        double result5 = sciCalc.add(25, 15);
        sciCalc.displayResult("+", 25, 15, result5);
        
        double result6 = sciCalc.multiply(7, 8);
        sciCalc.displayResult("*", 7, 8, result6);
        
        // Testing scientific operations
        System.out.println("\n--- Scientific Operations ---");
        double powerResult = sciCalc.power(2, 8);
        System.out.println("2 ^ 8 = " + powerResult);
        
        double sqrtResult = sciCalc.squareRoot(144);
        System.out.println("√144 = " + sqrtResult);
        
        double percentResult = sciCalc.percentage(500, 15);
        System.out.println("15% of 500 = " + percentResult);
        
        // Demonstrating polymorphism
        System.out.println("\n========== POLYMORPHISM DEMONSTRATION ==========");
        Calculator[] calculators = {new BasicCalculator(), new ScientificCalculator()};
        
        for (int i = 0; i < calculators.length; i++) {
            System.out.println("\nCalculator " + (i + 1) + ":");
            double res = calculators[i].add(100, 50);
            calculators[i].displayResult("+", 100, 50, res);
        }
        
        System.out.println("\n========== KEY POINTS ==========");
        System.out.println("1. Calculator is an ABSTRACT class defining common calculator structure");
        System.out.println("2. Abstract methods: add(), subtract(), multiply(), divide()");
        System.out.println("3. Concrete methods: displayResult(), isDivisionValid()");
        System.out.println("4. BasicCalculator and ScientificCalculator extend Calculator");
        System.out.println("5. Each subclass must implement all abstract methods");
        System.out.println("6. ScientificCalculator adds additional functionality (power, sqrt, percentage)");
        System.out.println("7. Polymorphism allows treating different calculators with same interface");
    }
}

/*
BENEFITS OF ABSTRACT CLASS IN THIS CALCULATOR APPLICATION:
- Provides a common structure for all calculator types
- Forces subclasses to implement essential operations
- Allows code reuse through concrete methods (displayResult, isDivisionValid)
- Enables polymorphism - different calculator types can be treated uniformly
- Promotes maintainability and extensibility
- Prevents instantiation of incomplete Calculator class
*/
