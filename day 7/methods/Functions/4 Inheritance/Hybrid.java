import java.util.*;

// Hybrid inheritance 

//interface where it should not contain body else error 
interface Animal {
    default void eat(){ //use of default/static if u want to get result from parent class 
        System.out.println("Animal eats");
    }
// void eat(); //No body
 }

interface Pet{
    void play();
}

class Dog implements Animal,Pet{
    // public void eat(){
    //     System.out.println("Dog eats bones");
    // }

        public void play(){
            System.out.println("Play with Dog");
        }    
}

class Cat implements Animal,Pet{
    public void eat(){
        System.out.println("Cat eats fish");
    }

        public void play(){
            System.out.println("Play with Cat");
        }    
}

class Puppy extends Dog{
    void bark(){
        System.out.println("Puppy barks");
    }

}

public class Hybrid {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.bark();
        p.eat(); // Inherits from Dog
        p.play(); // Inherits from Dog

        Cat cat = new Cat();
        cat.eat();
        cat.play();
        
    }
    
}


// Animal,Pet <- Dog, cat 
//Animal,Pet <-Dog <- Pubby 

// Animal - eat 
// Pet - play 