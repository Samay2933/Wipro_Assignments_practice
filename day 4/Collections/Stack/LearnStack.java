import java.util.*;

public class LearnStack {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
         

        //adding 
        animals.push("Lion");
        animals.push("Dog");
        animals.push("Horse");
        animals.push("Cat");
        
        //display
        System.out.println("Stack: "+animals);
        
        //peek , stack (LIFO) , so cat will be at top of stack 
        System.out.println("element being at top of stack :"+animals.peek());

        //pop  ,removes the top element 
        System.out.println("element to get pop: "+animals.pop());

        System.out.println("Stack: "+animals);


    }
    
}
