/*
 Create a Student class and display student details
name, age, and grade.

with constructor and without constructor 
 */
import java.util.*;

class students{

    String name ; 
    int age;
    int marks;

    public students(){

    }

    public students(String name, int age, int marks){
        this.name = name; 
        this.age = age;
        this.marks = marks;
    }

    void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Class: "+age);
        System.out.println("Grade: "+marks);
        System.out.println("--------------------");
    }
}

public class Student {
    public static void main(String[] args) {

        students s1 = new students(); //with default
        s1.name = "Sam";
        s1.age = 18;
        s1.marks = 99;

        s1.displayInfo();

        students s2 = new students("Ram", 22, 80); //parameterized constructor 
        s2.displayInfo();
        
    }
    
}
