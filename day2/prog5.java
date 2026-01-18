package day2;

public class prog5 {
    
    // Method 1: String reversal using predefined function (StringBuilder)
    public static String reverseUsingPredefined(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Method 2: String reversal without using predefined function
    public static String reverseWithoutPredefined(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
    
    
    public static void main(String[] args) {
        String original = "Hello World";
        
        System.out.println("Original String: " + original);
        System.out.println();
        
        // Using predefined function
        System.out.println("Method 1 (Using StringBuilder.reverse()):");
        System.out.println("Reversed: " + reverseUsingPredefined(original));
        System.out.println();
        
        // Without predefined function (String concatenation)
        System.out.println("Method 2 (Without predefined function - String concatenation):");
        System.out.println("Reversed: " + reverseWithoutPredefined(original));
        System.out.println();
        
        
    }
}
