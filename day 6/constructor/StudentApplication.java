import java.util.Scanner;
// # Student application
// 1. Add ## done
// 2. display ## done
// 3. display one ## done
// 4. delete (move each element up)
// 5. Modify (make nested menu in which you should ask what needs to be modifies )
// 6. sort as per the Marks

class Student {
    private String name;
    private int rollNo;
    private double marks;
    
    public Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
    
    // Getters
    public String getName() { 
        return name; 
    }
    public int getRollNo() { 
        return rollNo; 
    }
    public double getMarks() { 
        return marks; 
    }

    // Setters
    public void setName(String name) {
         this.name = name;
         }
    public void setMarks(double marks) { 
        this.marks = marks;
     }
    
     //Output generate
    public String toString() {
        return "Roll No: " + rollNo + "| Name: " + name + "| Marks: " + marks;
    }
}

public class StudentApplication {
    static Student[] students = new Student[5];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nSTUDENT APPLICATION MENU");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Display a student by Roll No.");
            System.out.println("4. Delete student");
            System.out.println("5. Modify student");
            System.out.println("6. Sort by Marks");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: addStudent(); 
                break;
                case 2: displayAll(); 
                break;
                case 3: displayByRollNo(); 
                break;
                case 4: deleteStudent(); 
                break;
                case 5: modifyStudent(); 
                break;
                case 6: sortByMarks(); 
                break;
                case 7: System.out.println("Exiting..."); 
                break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    static void addStudent() {
        if (count == 5) {
            System.out.println("List full!");
            return;
        }
        System.out.print("Enter name: ");
        sc.nextLine(); 
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        students[count++] = new Student(name, rollNo, marks);
        System.out.println("Student added!");
    }

    static void displayAll() {
        if (count == 0) {
            System.out.println("No students to display!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    static void displayByRollNo() {
        System.out.print("Enter roll number to search: ");
        int rollNo = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == rollNo) {
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == rollNo) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        students[count - 1] = null;
        count--;
        System.out.println("Student deleted!");
    }

    static void modifyStudent() {
        System.out.print("Enter roll number to modify: ");
        int rollNo = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNo() == rollNo) {
                int subChoice;
                do {
                    System.out.println("Modify Menu:");
                    System.out.println("1. Change name");
                    System.out.println("2. Change marks");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    subChoice = sc.nextInt();
                    sc.nextLine(); 
                    switch (subChoice) {
                        case 1:
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            students[i].setName(newName);
                            System.out.println("Name updated!");
                            break;
                        case 2:
                            System.out.print("Enter new marks: ");
                            double newMarks = sc.nextDouble();
                            students[i].setMarks(newMarks);
                            System.out.println("Marks updated!");
                            break;
                        case 3:
                            System.out.println("Exiting modify menu...");
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                } while (subChoice != 3);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void sortByMarks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted by marks!");
        displayAll();
    }
}
