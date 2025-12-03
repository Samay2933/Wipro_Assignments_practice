import java.util.*;

class Car{
    private String brand;
    String color;
     
    //Getter for brand 
    public String get_brand(){
        return brand;
    }
    //Setter for brand 
    public void setBrand(String brand){
        this.brand = brand;
    }
}

public class encapsulation {
    public static void main(String[] args) {
        Car c1 = new Car();

        //c1.brand = "Tata"; //no access, thats why we will use getter and setter 
        c1.setBrand("Toyota");
        // Set the color directly (could also use a setter for full encapsulation)
        c1.color = "Pink";
        
        System.out.println("brand: "+ c1.get_brand());
        System.out.println("Color: " + c1.color);
    }
    
}
