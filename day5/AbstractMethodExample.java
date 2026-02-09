abstract class Animal{
    abstract void makeSound();
    void eat(){
        System.out.println("This animal eats food.");
    }
}
class Dog extends Animal{
    void makeSound(){
        System.out.println("Woof");
    }
}
public class AbstractMethodExample {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        animal.eat();
    }
}
