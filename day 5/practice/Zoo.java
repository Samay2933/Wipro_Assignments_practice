class Animal{
    void eat(){
        System.out.println("Animal eats");
    }

    class Dog extends Animal{
    void sound(){
        System.out.println("Dog Barks");
    }
} 

}

public class Zoo {
    public static void main(String[] args) {

        Animal a = new Animal();
        Animal.Dog d = a.new Dog();

        d.sound();

    }
    
}
