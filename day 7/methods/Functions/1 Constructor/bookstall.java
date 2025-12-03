import java.util.*;

class Books{
    static int bookcount=0;
    String name; 
    String author;
    int year; 

    Books(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;

        bookcount++;
    }

    static void showbookcount(){
        System.out.println("Book count: "+bookcount);
    }

    void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Author: "+author);
        System.out.println("Year: "+year);
        System.out.println("--------------------");
    }
}

public class bookstall {
    public static void main(String[] args) {

        Books b1 = new Books("Harry Potter", "John doe", 2020);
        Books b2 = new Books("Java", "abc", 2021);
    
        b1.displayInfo();
        b2.displayInfo();

        Books.showbookcount();
    }
}


//add b3 without passing arguments 