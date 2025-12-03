import java.util.*;
class Calculator{
    public int add(int a, int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a*b*c;
    }

    public int add(int a){
        return a%2;
    }
}

public class poly {
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();

        System.out.println(calc.add(2,3));
        System.out.println(calc.add(2,3, 5));
        System.out.println(calc.add(2));
      
    }
    
}
