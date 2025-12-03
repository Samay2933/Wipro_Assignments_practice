/*
 Q3: Write a program to display all elements of a queue without removing them. Without using Poll.

 */

import java.util.*;
public class queuedisplay {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println("Queue elements (without removing):");
      
        List<Integer> list = new ArrayList<>(queue);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
       
        System.out.println("Queue after display: " + queue);
    }
}