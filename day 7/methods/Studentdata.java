import java.util.*;

class Student {
    private String name;
    private int rollno;
    private double marks;

    // Getters and Setters for name,rollno,marks
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for rollno
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) { // Corrected parameter type
        this.rollno = rollno;
    }

    // Getters and Setters for marks
    public double getMarks() {
        return marks;
    }

    // public void setMarks(double marks) { // Corrected parameter type
    //     this.marks = marks;
    // }

    public void setMarks(double marks) { // Corrected parameter type
        this.marks = marks;
    }

    // Default Constructor
    public Student() { // Constructor should be public
        System.out.println("Default Constructor Called");
    }
}

public class Studentdata {
    public static void main(String[] args) {
        Student s1 = new Student();

        // Using setters to set values for private variables
        s1.setName("John");
        s1.setRollno(12);
        s1.setMarks(80);

        // Using getters to retrieve and print values of private variables
        System.out.println("Student name : " + s1.getName());
        System.out.println("Roll no: " + s1.getRollno());
        System.out.println("marks : " + s1.getMarks());
    }
}

/*
 * 
 class Student{
    private String name;
    private int rollno;
    private double marks;

    //Getters and setters for name, rollno, marks 

    private String getName(){  //get : name 
        return name;
    }

    private void setName(String name){ //Set : name 
        this.name = name; //not retruning , but accepting the value 
    }

    //do this for others as well 
    private int getRollno(){  //get : rollno 
        return rollno;
    }

    private void setrollno(int rollno){ //Set : rollno
        this.rollno = rollno; //not retruning , but accepting the value 
    }

    public double getMarks(){  //get : marks 
        return marks;
    }

    // private void setMarks(double marks ){ //Set : marks 
    //     this.marks = marks; 
    // }

    // Adding 10% grace marks 
    public void setMarks(double marks ){ //Set : marks   
        this.marks = marks + (0.1 * marks); 
    }

    //Default Constructor 
    
    //Initialize the default values ; or to perform the actions which you might do it before the object creation; example : connection with database is done here 
    
    Student(){
        System.out.println("Default constructor called");
    }
    //Parameterized Constructor
    Student(String name, int rollno, double marks){
        this.name = name ; 
        this.rollno = rollno;
        //this.marks = marks ; 
        this.setMarks(marks);
    }

    // Display student info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Rollno: " + rollno);
        System.out.println("Marks (with grace): " + marks);
    }


}

public class demo{
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2= new Student("John doe", 101, 85);
        s2.displayInfo();
        
    }
}

 */