import java.util.*;
/*
 Create a Student Class, and apply getter and setter methods to give access to private variable marks.

 */
class Student{
    private int marks;
    String name;

    //Getter
    public int getmarks(){
        return marks;
    }

    //Setter
    public void setmarks(int marks){
        this.marks = marks;

    }
}

public class marksencap {
    
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = "Ram";  //default 

        s1.setmarks(23); //setting marks 

        System.out.println("Name: "+s1.name);
        System.out.println("Marks: "+ s1.getmarks());

        
    }
}
