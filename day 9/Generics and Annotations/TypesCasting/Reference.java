class Animal {
    void eat() { System.out.println("Animal eats"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}


public class Reference {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting (automatic)
        a.eat();              // Animal method
        
        
        Dog d = (Dog) a;      // Downcasting (needs cast)
        d.bark();             // Dog method
    }
}