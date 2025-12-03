//Constructor Demo
import java.util.*;

class Book{
    //Data members
    String title = "Harry Potter";
    String author = "ABC";
    double price = 500;

    Book(){ //changing the name this Book wont be the constructor , since ; "name is same as the class name"
        System.out.println("default constructor");
    } //if it changed , it will be normal method 

    //Parameterized Constructor 

    Book(String title,String author, double price){
        this.title = title;
        this.author =author;
        this.price = price;
    }

}
public class constructors {
    public static void main(String[] args) {

        //Book book1 = new Book();
        //new Book();

        Book book2 = new Book("Java", "John doe", 700);
        System.out.println(book2.title);

        
    }
}

//practice self 
/*


 * 
 class Book{
    String title ="Harry potter";
    String author = "John doe";
    double price = 500;

    Book(){
        System.out.println("This is default const");
    }

    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayInfo(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: $"+price);
    }
}


public class demo {
    public static void main(String[] args) {
        Book book1 = new Book();
        //System.out.println("Title: "+book1.title);
        book1.displayInfo();
        System.out.println("-----");

        Book book2 = new Book("Java", "Sam", 700);
    //System.out.println("Title: "+ book2.title);
    book2.displayInfo();
    System.out.println("-----");
        
    }   
}

 * 
 */ 


 /*
  * Person question 
import java.util.*;

class Person {
    String name;
    int age; 

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();
        // Object creation 
        Person p = new Person(name, age);

        System.out.println("Name: " + p.name);
        System.out.println("Age: " + p.age);

        sc.close();
    }   
}

  */


/*
 * 
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

        sc.close();
        
    }
}
 */