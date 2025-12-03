import java.util.*;

public class LearnPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(40);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);

        System.out.println(pq);
        
        //for now, smallest value has the higher pripority 
        //after element pops , chance the list arrange changes 
        //uses min heap data structure 

        pq.poll();
        System.out.println(pq);

        //peek()
        
        System.out.println("peek: "+pq.peek());

    }
    
}


//PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//want to reverse the order: converts min heap to max heap 