import java.util.*;

class Calculator{

    int a;
    int b;
    // int a = 10;
    // int b = 5;
    //Method without parameters and without return type
    void greet(){
        System.out.println("Welcome to calculator!");
        System.out.println("Sum from greet: "+(a+b));

    }

    //Method with parameters and without return type 
    void add(int a, int b){
        this.a = a;
        this.b = b;
        System.out.println("Sum: "+(a+b));

    }

    //Method with multiple parameters 
    void hello(String name, String message, int count){
        for(int i=0;i<count;i++){
            System.out.println("Hello "+name+","+message);
        }
    }

    //Method with return type
    int multiply(int x, int y){
        return x*y;
    }


    // //Using in Strings 
    // String getGreetingMessage(String name){
    //     return "Hello, " + name + "! Welcome to the program.";
    // }
}

public class methoddemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.greet(); //method calling without arguments 
        calc.add(5,15); //method calling with arguments  //if b = 15 then overwrites that
        calc.hello("Alice", "Welcome to class",2);
        int result = calc.multiply(4,5);
        System.out.println("multiplcation result: "+result);

    //     String getGreetingMessage(String name){
    //     return "Hello, " + name + "! Welcome to the program.";
    // }
    }
}
