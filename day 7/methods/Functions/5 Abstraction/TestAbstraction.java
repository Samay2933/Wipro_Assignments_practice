abstract class Animal {
    abstract void makeSound(); // Abstract method
    
    void sleep() {             // Non-abstract method
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void makeSound() {         // Must provide its own version
        System.out.println("Woof!");
    }
}

public class TestAbstraction {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();  // Prints: Woof!
        d.sleep();      // Prints: Sleeping...
    }
}
