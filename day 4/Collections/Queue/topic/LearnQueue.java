//front end , rear end 
//deletion from left , 
//addition from right 
// A B C D 
//LILO , FIFO 

import java.util.*;

public class LearnQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        //add
        //add throws exception if task unsuccessful 
        //offer returns false if task unsuccessful 
       
        queue.offer(12);
        queue.offer(24);
        queue.offer(36);
        //queue.add(11);  //add is also used 

        System.out.println(queue);
        

        //poll , pops and also returns the value
        //poll() returns null if empty  
        //remove() can be also return 
        System.out.println(queue.poll());
        System.out.println(queue);
        
        //peek() tells the next top element 
        //peek() gives null if queue is empty 
        System.out.println(queue.peek());
        System.out.println(queue);







    }
    
}

/*
 add()
 offer()

 */
