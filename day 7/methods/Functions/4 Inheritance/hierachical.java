import java.util.*;

// Hierachical inheritance 

class Animal{
    void eat(){
        System.out.println("Animall eats");
    }
}

class Dog extends Animal{
    void sound(){
        System.out.println("Dog barks");
    }
}

class Cat extends Animal{
    void sound(){
        System.out.println("Cat meows");
    }
}
public class hierachical {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();

        d.sound();
        c.sound();

        d.eat();
        c.eat();
    }
    
}


// Animal <- Dog()
 // Animal <- Cat()