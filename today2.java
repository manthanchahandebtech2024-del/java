public class today2 {
    class Parent {
        final void display() {
            System.out.println("Final method in Parent class.");
        }
    }
    class Child extends Parent {
        // Attempting to override the final method will cause a compile-time error
        /*
        void display() {
            System.out.println("Overriding final method in Child class.");
        }
        */
    }
    public class FinalMethodExampl {
        public static void main(String[] args) {
            
            Child child = today2.Child();
            child.display();
        }
    
        
    }
    public static today2.Child Child() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Child'");
    }
}
