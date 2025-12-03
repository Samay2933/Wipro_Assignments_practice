import java.util.*;

class Bookinfo{
    //Data members
    String title = "Unknown";
    String author = "ABC";
    double price = 500;
    //member function 
    void displayInfo(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: $"+price);
    }
}
public class book {
    public static void main(String[] args) {
        //Object Creation 
        Bookinfo book1 = new Bookinfo(); //constructor
        
        //Method calling/invocation
        book1.displayInfo();
        //new Bookinfo().displayInfo();

        Bookinfo book2 = new Bookinfo();
        book2.title = "Java";
        book2.author ="John Doe";
        book2.price = 750;
        book2.displayInfo();


        book2 = book1;
        book2.displayInfo();
        book1.title = "Data Structure";
        book1.displayInfo();
        
    }
}
