// Java Program to Solve Diamond Problem Using Interfaces

// Top interface
interface Animal {
    void eat();
    void sleep();
}

// Left interface
interface Mammal extends Animal {
    void walk();
}

// Right interface
interface Bird extends Animal {
    void fly();
}

// Class implementing both interfaces - solves diamond problem
class Bat implements Mammal, Bird {
    
    @Override
    public void eat() {
        System.out.println("Bat eats insects");
    }
    
    @Override
    public void sleep() {
        System.out.println("Bat sleeps during day");
    }
    
    @Override
    public void walk() {
        System.out.println("Bat can crawl on ground");
    }
    
    @Override
    public void fly() {
        System.out.println("Bat flies in night");
    }
}

class Duck implements Mammal, Bird {
    
    @Override
    public void eat() {
        System.out.println("Duck eats grains and insects");
    }
    
    @Override
    public void sleep() {
        System.out.println("Duck sleeps at night");
    }
    
    @Override
    public void walk() {
        System.out.println("Duck walks on land");
    }
    
    @Override
    public void fly() {
        System.out.println("Duck flies in air");
    }
}

public class Interface {
    public static void main(String[] args) {
        System.out.println("===== DIAMOND PROBLEM SOLUTION USING INTERFACES =====\n");
        
        // Bat object
        System.out.println("-- BAT --");
        Bat bat = new Bat();
        bat.eat();
        bat.sleep();
        bat.walk();
        bat.fly();
        
        // Duck object
        System.out.println("\n--- DUCK ---");
        Duck duck = new Duck();
        duck.eat();
        duck.sleep();
        duck.walk();
        duck.fly();
        
        // Polymorphism demonstration
        System.out.println("\n- POLYMORPHISM -");
        Animal[] animals = {bat, duck};
        
        for (Animal animal : animals) {
            animal.eat();
            animal.sleep();
        }
      
}
