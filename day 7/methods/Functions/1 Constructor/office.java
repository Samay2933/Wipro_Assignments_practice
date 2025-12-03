import java.util.*;

/*
 Create an Employee class with the following:
name, salary, department, and create multiple constructors.
 */

 class Employee{
    String name;
    int salary;
    String department;


    public Employee(String n, int s, String d){ //three parameters
        this.name = n;
        this.salary = s;
        this.department = d;
        
        System.out.println("3 parameters");
    }

    //default constructor 
    public Employee(){
        name = "Unknown";
        salary = 0;
        department = "Unassigned";
        System.out.println("default constructor");
    }


    public Employee(String name){
        this.name = name;
        this.salary = 10000;
        this.department = "Finace";
        System.out.println("With one parameter; name ");
    }

    public Employee(int salary){ //one paramter: salary 
        this.name = "Fish";
        this.salary = salary;
        this.department = "Finace";
        System.out.println("With one parameter; salary ");
    }

    public Employee(String name, String department){ //two paramter: name, department 
        this.name = name;
        this.salary = 99999;
        this.department = department;
        System.out.println("With two parameter; name, department ");
    }

    public Employee(int salary, String department){ //two paramter: salary, department 
        this.name = "Mickey";
        this.salary = salary;
        this.department = department;
        System.out.println("With two parameter; salary, department ");
    }

    // // ✅ Constructor with department only
    // public Employee(String department, boolean isDepartment) {
    //     this.name = "Unknown";
    //     this.salary = 0;
    //     this.department = department;
    //     System.out.println("Constructor with 1 parameter: department");
    // }


    void displayInfo(){
        System.out.println("Name: "+ name);
        System.out.println("salary: "+ salary);
        System.out.println("department: "+ department);
        System.out.println("----------------------");

    }
 }

public class office {
    public static void main(String[] args) {

        Employee e1 = new Employee();  //default constructor 
        Employee e2 = new Employee("Ansh"); //input: name 
        Employee e3 = new Employee(7979); //input: salary 
        Employee e4 = new Employee(); //input: department 
        //Employee e6 = new Employee("HR", true); // ✅ department only
        Employee e5 = new Employee("Harry","HR"); //input: name,department 
        Employee e6 = new Employee(111111, "Admin"); //input: salary,department 
        Employee e7 = new Employee("Anurag", 8888, "Engineer"); //input: name,salary,department 

        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();
        e5.displayInfo();
        e6.displayInfo();
        e7.displayInfo();
        
    }
    
}



/*
 * 
public class Employee {
    static int empCount; 
    String name;
    double salary;
    String department;
    public Employee() {
        name = "Unknown";
        salary = 0.0;
        department = "Unassigned";
        empCount++;
        System.out.println("Default Constructor Called (No Parameters)");
    }
    public Employee(String name) {
        this.name = name;
        salary = 0.0;
        department = "Unassigned";
        empCount++;
        System.out.println("Constructor with 1 Parameter Called");
    }
public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        department = "Unassigned";
        empCount++;
        System.out.println("Constructor with 2 Parameters Called");
    }
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        empCount++;
        System.out.println("Constructor with 3 Parameters Called");
    }
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Employee Count: " + empCount);
    }
static void showEmpCount() {
        System.out.println("Total Employees Created: " + empCount);
    }
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.displayInfo();
        System.out.println("==============");
        Employee e2 = new Employee("Ganesh");
        e2.displayInfo();
        System.out.println("=================");
        Employee e3 = new Employee("Ram", 50000);
        e3.displayInfo();
        System.out.println("==================");
        Employee e4 = new Employee("Balaji", 75000, "HR");
        e4.displayInfo();
        System.out.println("=================");
        Employee.showEmpCount(); 
    }
}
 */

