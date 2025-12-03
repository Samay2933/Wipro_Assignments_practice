//notes by teacher

import java.util.*;
class Student {
    private SFactorialing name;
    private int rollNo;
    private double marks;
    //Getters and Setters for name, rollNo, marks.
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    private void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    private double getMarks() {
        return marks;
    }
    private void setMarks(double marks) {
        this.marks = marks;
    }
    // Default Constructor
    Student() {
        System.out.println("Default Constructor Called");
    }
    // Parameterized Constructor
    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.setMarks(marks);
    }
    void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
                System.out.println("Marks: " + marks);
    }
}
class p3 {
   
    void menu() {
        System.out.println("Menu");
        System.out.println("1. Add Student");
        System.out.println("2. Display Student");
        System.out.println("3. Search Student by Roll No");
        System.out.println("0. Exit");
    }
    public static void main(String[] args) {
        p3 obj = new p3(); //main-> p3 , since our class p3 contains menu 
        Student [] students =new Student[3]; 
         Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            obj.menu();
            System.out.print("Enter your choice: ");   
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    for(int i=0;i<students.length;i++){
                        if(students[i]==null){
                            System.out.print("Enter Name: ");                  
                            String name = sc.next();
                            System.out.print("Enter Roll No: ");
                            int rollNo = sc.nextInt();
                            System.out.print("Enter Marks: ");                  
                            double marks = sc.nextDouble();
                            students[i]= new Student(name,rollNo,marks);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Student Details:");
                    for(Student s : students){
                        if(s!=null){
                            s.displayInfo();
                            System.out.println("-----");
                        }
                    }
                    break;
                       case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRollNo = sc.nextInt();
                    boolean found = false;
                    for(Student s : students){
                        if(s!=null && s.getRollNo() == searchRollNo){
                            s.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
    }while (choice != 0);
        sc.close();
    }
}

// public class p3 {
    
// }
