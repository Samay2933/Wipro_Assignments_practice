
//package Functions;
import java.util.*;


class Car{
    private String brand; //not to get outside this Car class 
    String color;
}
public class encap {
    public static void main(String[] args) {
        Car car1 = new Car();
        //car1.brand;  //cannot be access brand 
        car1.color = "Pink";
    }

    
}
