import java.util.*;

/*
 Q2: Given a queue of integers, reverse its elements and print the final queue. 
 Input: [1, 2, 3, 4] 
 Output: [4, 3, 2, 1]

 */

public class queuereverse {
    public static void main(String[] args) {
        Queue<Integer> s1 = new LinkedList<>();

        // Add elements
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);

        System.out.println("Original List: " + s1);

        Stack<Integer> s2 = new Stack<>(); // stack to reverse

        // Move all elements from queue to stack
        while (!s1.isEmpty()) {
            s2.push(s1.remove());
        }

        // Move back from stack to queue (reversed order)
        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }

        System.out.println("Reversed queue: " + s1);
    }
}


// public class test {
//     public static void main(String[] args) {
//         Queue<Integer> s1 = new LinkedList<>();
//         //Queue<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        
//         //add
//         s1.add(1);
//         s1.add(2);
//         s1.add(3);
//         s1.add(4);

//         System.out.println("Original List: "+s1);

//         Stack<Integer> s2 = new Stack<>();//stack to reverse 

//         while(!s1.isEmpty()){
//             s2.push(s1.remove());
          
//         }


//         while(!s2.isEmpty()){
//             s2.add(s2.pop());
           
//         }
//         System.out.println("reversed queue: "+s1);
            
//     }
    
// }


//student code 

// import java.util.*;
// public class queuereverse {
//     public static void main(String[] args) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.add(1);
//         queue.add(2);
//         queue.add(3);
//         queue.add(4);
//         System.out.println("Original Queue: " + queue);
//         ArrayList<Integer> l1 = new ArrayList<>(queue);
//         queue.clear();
//         for (int i = l1.size() - 1; i >= 0; i--) {
//             queue.add(l1.get(i));
//         }
//         System.out.println("reversed Queue: " + queue);
//     }
// }