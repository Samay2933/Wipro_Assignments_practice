import java.util.*;

public class car {
    static int car_count; //created a static variable 
    String brand;
    String color;
    int year;

    public car(String b, String c, int y){
        this.brand =b;  //this keyword refer to the current obj
        this.color = c;
        this.year = y;
        //'this' helps to indicate instance variables & also present invoking object

        

        car_count++; //counts the number of cars , if passed through parametrized
        
        // brand = b;
        // color = c;
        // year = y;
    }

    car(){ // can be also left blank // this is default constructor , 
        System.out.println("Default constructor");
    }

    // car(){ // can be also left blank // this is default constructor , 
       
    // }

    static void showCarCount(){
        System.out.println("total count : "+car_count);
    }

    void displayInfo(){
        System.out.println("Brand: "+brand);
        System.out.println("Color: "+color);
        System.out.println("Year: "+year);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        car myCar = new car();
      
        myCar.brand = "Mclaren";
        myCar.color = "Orange";
        myCar.year = 2025;

        myCar.displayInfo();

        car car2 = new car("Tata", "white", 2020 );
        car2.displayInfo();

        // car car3 = new car("Morini", "red", 2040 );
        // car3.displayInfo(); //counts : 2 , 1 - tata , 2 this 

        // System.out.println(car_count);

        car.showCarCount(); //can be car2.showCarCount();
    }
}