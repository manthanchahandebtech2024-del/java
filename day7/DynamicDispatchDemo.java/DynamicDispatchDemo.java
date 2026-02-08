class Parent{
    void show(){
        System.out.println("Parent's show method");
    }
}

class Child extends Parent{
    @Override
    void show(){
        System.out.println("Child's show method");
    }
}

public class DynamicDispatchDemo {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent childAsParent = new Child(); // Upcasting
        
        parent.show(); // Upcasting
        childAsParent.show(); // Calls Child's show() method due to dynamic dispatch
    }
}