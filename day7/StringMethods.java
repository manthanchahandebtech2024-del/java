public class StringMethods{
    publi static void main(String[] args){
        String str = "Java programming:";
        System.out.println("Length:" + str.length());
        System.out.println("Trimmed:" + str.trim());
        System.out.println("Uppercase:" + str.toUpperCase());
        System.out.println("Substring(2,6):" + str.substring(2,6));
        System.out.println("Replaced Java with Python: "   + str.replace("Java", "Python");
        
    }
}