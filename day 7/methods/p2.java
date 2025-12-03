//notes by mentor

class Calculator {
    int a;
    int b;
    // Method without parameters and without return type
    void greet() {
        System.out.println("Welcome to the Calculator!");
         System.out.println("Sum: from greet Method " + (a + b));
    }
    // Method with parameters and without return type
    void add(int a, int b) {
        // this.a = a;
        // this.b = b;
        System.out.println("a from add: " + a);
        System.out.println("b from b: " + b);
       
    }
    // Method with multiple parameters
    void hello(String name,String message,int count){ 
        for(int i=0;i<count;i++){
            System.out.println("Hello " + name + ", " + message);
        }
    }
    // Method with return type
    int multiply(int x, int y){
        return x * y;
    }
    String getGreetingMessage(String name){
        return "Hello, " + name + "! Welcome to the program.";
    }
       
}
class Calculator {
    int a;
    int b;
    // Method without parameters and without return type
    void greet() {
        System.out.println("Welcome to the Calculator!");
         System.out.println("Sum: from greet Method " + (a + b));
    }
    // Method with parameters and without return type
    void add(int a, int b) {
        // this.a = a;
        // this.b = b;
        System.out.println("a from add: " + a);
        System.out.println("b from b: " + b);
       
    }
    // Method with multiple parameters
    void hello(String name,String message,int count){ 
        for(int i=0;i<count;i++){
            System.out.println("Hello " + name + ", " + message);
        }
    }
    // Method with return type
    int multiply(int x, int y){
        return x * y;
    }
    String getGreetingMessage(String name){
        return "Hello, " + name + "! Welcome to the program.";
    }
       
}