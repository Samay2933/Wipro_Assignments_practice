import java.util.*;

//Multilevel inheritance

class Animal{
    void eat(){
        System.out.println("Animal eats");
    }
}

class Dog extends Animal{
        void sound(){
            System.out.println("Dog barks");
        }
    }

class Babydog extends Dog{
    void sound(){
        System.out.println("bark bark");
    }
}

public class multilevel {
    public static void main(String[] args) {

        Babydog bd = new Babydog();
        bd.eat();
        bd.sound();
        
    }
}


// Animal <- Dog <- Babydog
