//learn with fresh mind update later 
import java.util.*;


public class new_car {
  private String brand;
  private int year;
  

  public new_car(String brand, int year) {  //creat
    this.brand =brand;
    this.year = year;
    
  }


  public void displayInfo(){
    System.out.println("Brand: "+brand);
    System.out.println("Year: "+year);
    System.out.println("-------------------");
  }

  public static void main(String[] args) {
    new_car c1 = new new_car("Toyota", 1990);

  c1.displayInfo();

  c1.brand = "maruti";

  System.out.println(c1.brand);
  System.out.println(c1.year);
    
  }
}