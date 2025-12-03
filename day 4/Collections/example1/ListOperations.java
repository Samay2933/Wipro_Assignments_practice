import java.util.*;


/*
 Q1. Implement all these methods and see the outputs.


Q5. Merge two lists, remove duplicates, and sort in ascending order. List 1: [3, 5, 7, 5] . List 2: [2, 7, 8, 3].
Output : [2, 3, 5, 7, 8]

 */
public class ListOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("List after adding: " + list);

        // get element at index 2
        int element = list.get(2);
        System.out.println("Element at index 2: " + element);

        // set element at index 1
        list.set(1, 25);
        System.out.println("List after setting index 1 to 25: " + list);

        // check if list contains 30
        boolean containscheck = list.contains(30);
        System.out.println("List contains 30: " + containscheck);

        // get index of element 40
        int index = list.indexOf(40);
        System.out.println("Index of 40: " + index);

        // remove element at index 0
        list.remove(0);
        System.out.println("List after removing element at index 0: " + list);

        // size of list
        int size = list.size();
        System.out.println("Size of list: " + size);

        // clear the list
        list.clear();
        System.out.println("List after clearing: " + list);


        //List<Integer> list = new ArrayList<>(Arrays.asList(10, 30, 20, 20, 10, 30, 20, 40));

    }
}

