import java.util.*;

//Single inheritance 

class Animal{
    void eat(){
        System.out.println("Animal eats");
    }

}

class Dog extends Animal{
            void bark(){
                System.out.println("Dog barks");
            }

            void eat(){  //overwriting eat() 
                //super.eat(); //Calls Animal's eat
                System.out.println("Dog eats bones");
            }
        }

public class single {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.bark();
        d.eat();

    }    
}

//Animal <- Dog
//Dog inherits from Animal (one parent, one child)