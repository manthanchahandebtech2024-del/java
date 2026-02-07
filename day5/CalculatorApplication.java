// Compact Calculator using Abstract Class

abstract class Calculator {
    public abstract double add(double a, double b);
    public abstract double subtract(double a, double b);
    public abstract double multiply(double a, double b);
    public abstract double divide(double a, double b);
    
    public void show(String op, double a, double b, double result) {
        System.out.println(a + " " + op + " " + b + " = " + result);
    }
}

class BasicCalculator extends Calculator {
    public double add(double a, double b) { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b) { return (b != 0) ? a / b : 0; }
}

class ScientificCalculator extends Calculator {
    public double add(double a, double b) { return a + b; }
    public double subtract(double a, double b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(double a, double b) { return (b != 0) ? a / b : 0; }
    public double power(double base, double exp) { return Math.pow(base, exp); }
    public double sqrt(double num) { return Math.sqrt(num); }
    public double percent(double num, double p) { return (num * p) / 100; }
}

public class CalculatorApplication {
    public static void main(String[] args) {
        System.out.println("=== CALCULATOR APPLICATION ===\n");
        
        Calculator basic = new BasicCalculator();
        System.out.println("Basic Calculator:");
        basic.show("+", 15, 8, basic.add(15, 8));
        basic.show("-", 20, 7, basic.subtract(20, 7));
        basic.show("*", 6, 9, basic.multiply(6, 9));
        basic.show("/", 50, 5, basic.divide(50, 5));
        
        ScientificCalculator sci = new ScientificCalculator();
        System.out.println("\nScientific Calculator:");
        sci.show("+", 25, 15, sci.add(25, 15));
        sci.show("*", 7, 8, sci.multiply(7, 8));
        System.out.println("2 ^ 8 = " + sci.power(2, 8));
        System.out.println("√144 = " + sci.sqrt(144));
        System.out.println("15% of 500 = " + sci.percent(500, 15));
    }
}
