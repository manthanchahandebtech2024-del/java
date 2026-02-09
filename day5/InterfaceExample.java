interface Animal{
    void sound();
}
class Dog implements Animal{
    public void sound(){
        System.out.println("Woof");
    }
}
public class InterfaceExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound();
    }
}