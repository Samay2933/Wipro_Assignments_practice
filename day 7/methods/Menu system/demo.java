import java.util.Scanner;

class Person {
    String name; 
    int age ; 

    Person(){
        System.out.println("Default constructor");
    }

    Person(String name, int age){
        this.name = name; 
        this.age = age;
    }

    void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);

    }

}

public class demo{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name : ");
        String names = sc.nextLine();
        System.out.println("Enter age : ");
        int ages=sc.nextInt();

        Person p = new Person();
        Person p1 = new Person("Sam", 23);
        p1.displayInfo();

        Person p2 = new Person(names, ages);
        p2.displayInfo();
        
    }
}