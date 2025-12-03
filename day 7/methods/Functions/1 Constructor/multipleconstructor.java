import java.util.*;

public class multipleconstructor {
    static int car_count; // Created a static variable
    String brand;
    String color;
    int year;

    // Parameterized constructor
    public multipleconstructor(String b, String c, int y) {
        this.brand = b;  // this keyword refers to the current object
        this.color = c;
        this.year = y;
        car_count++; // counts the number of cars created by parameterized constructor
        System.out.println("got called with parameters");
    }

    // Default constructor
    public multipleconstructor(){
        brand = "Any brand";
        color = "Any Color";
        year = 2020;
        car_count++;
        System.out.println("I got called without parameter");
    }

    public multipleconstructor(String brand){ //brand input user 
        this.brand = brand;
        color = "Default";
        year = 1900;
        System.out.println("I was called with 1 parameter");

    }

//     public multipleconstructor(String color) { //color input user 
//     brand = "hehehe";
//     this.color = color;
//     year = 1910;
//     car_count++;
//     System.out.println("I was called with color only");
// }  //need to use boolean color,coloronly ; pink,true , this this block gets execute 



    // Static method to display car count
    static void showCarCount() {
        System.out.println("total count : " + car_count);
    }

    // Instance method to display car details
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        multipleconstructor myCar = new multipleconstructor();
        myCar.brand = "Mclaren";
        myCar.color = "Orange";
        myCar.year = 2025;

        myCar.displayInfo();

        multipleconstructor car2 = new multipleconstructor("Tata", "white", 2020);
        car2.displayInfo();

        // Uncomment to test further:
        // multipleconstructor car3 = new multipleconstructor("Morini", "red", 2040);
        // car3.displayInfo();

        multipleconstructor car4 = new multipleconstructor("Toyota"); //calls with one parameter
        car4.displayInfo();

        // multipleconstructor car5 = new multipleconstructor(color = "pink"); //calls with one parameter
        // car5.displayInfo();

        multipleconstructor.showCarCount(); // Can also use car2.showCarCount()
    }
}