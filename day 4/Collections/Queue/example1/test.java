import java.util.*;

/*
 Create a queue of integers. Perform the following operations: Add 3 elements (10, 20, 30)
Remove one element
Print the front element
Print the entire queue
 */
public class test {
    public static void main(String[] args) {

        Queue<Integer> s1 = new LinkedList<>();
        
        //add
        s1.add(10);
        s1.add(20);
        s1.add(30);

        System.out.println("List after adding elements: "+s1);

        //remove
        s1.remove(10); //remove the mentioned value element //not index 
        //s1.remove(); //removes the head
        
        System.out.println("Removed one element: "+s1);

        //Print the front element 
        int front_element = s1.peek();
        System.out.println("front element: "+front_element);

        //Print the entire queue 

        System.out.println("final queue: "+s1);
    }
    
}


//if want to remove by index convert to array 