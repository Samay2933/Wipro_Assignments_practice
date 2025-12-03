import java.util.*;

/*
 Create a Person class with a name and displayInfo() method. 
 Create a Student class that extends Person, adds a rollNumber, and overrides displayInfo(). 
 Use super to call the parent class method inside the overridden method.
 */

 class Person{
    String name;

    Person(String name){
        this.name = name;
    }


    void displayInfo(){
        System.out.println("Name: "+name);

    }
 }

 class Student extends Person{
    int rollno;

    // // Default constructor: Assigns default name and rollno
    // Student() {
    //     super("Unknown");
    //     this.rollno = -1; // default uninitialized value
    // }

    Student(String name, int rollno){
        super(name); //calls parent class constructor 
        this.rollno = rollno;
    }
 // Overloaded constructor with only name
    Student(String name){
        super(name); //calls parent class constructor 
        
    }

    @Override  //habbit to write this 
    void displayInfo(){
        super.displayInfo();//calls parent class constructor 
        System.out.println("Roll Number: "+ rollno);
    }

 }
public class schoolwork {

    public static void main(String[] args) {
        Student s1 = new Student("Harry", 23);
        Student s2 = new Student("Ram");
        s1.displayInfo();
        s2.displayInfo();
        
    }
}

/*
 will not compile successfully because you're trying to create a Student object with only a name: Student s2 = new Student("Ram");
However, in Student class, we have only defined a constructor that takes both a name and a rollno as parameters. 
Java will throw an error because it can't find a suitable constructor.​

Solution : 
To solve this, need to overload the constructor in your Student class to also allow creation with only a name (and provide a default value for rollno).
 */