import java.util.*;

public class LearnArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq= new ArrayDeque<>();
    
    adq.offer(23);

    adq.offerFirst(12);
    adq.offerLast(45);
    
    adq.offer(26);
    
    System.out.println(adq);
    
    //peek()
    System.out.println("Peek: "+adq.peek());
    System.out.println("PeekFirst: "+adq.peekFirst());
    System.out.println("Peeklast: "+adq.peekLast());

    //poll
    System.out.println("Poll: "+adq.poll());
    System.out.println(adq);
    //polllast
    System.out.println("Polllast: "+adq.pollLast());
    System.out.println("Polllast list : "+adq);
    
    System.out.println("PollFist: "+adq.pollFirst());
    System.out.println("PollFirst list: "+adq);


    
    }

    




    // 
     
    
}
