import java.util.*;
public class L1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        //add
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);
        //always adds at the end 

        //remove 
        list.remove(3); //removes by index
        System.out.println(list);
        System.out.println("size of array: "+list.size());

        //remove the first occureance of value 
        list.remove(Integer.valueOf(20));
        System.out.println("list after removed value of 20: "+list);

        //adding at particular 
        //method overloading 

        list.add(1,24);
        System.out.println("add the new element at index 2 : "+list);
        

        //creating a new list 
        List<Integer> newlist = new ArrayList<>();

        newlist.add(100);
        newlist.add(200);
        System.out.println("newlist elements: "+newlist);

        //add all the elemnts to list+newlist 

        list.addAll(newlist);
        System.out.println("merge list : "+list);

        //contains //replies in true false 
        System.out.println("checks if the 50 value is there or not: "+list.contains(50));


        //get element , mention index 
        System.out.println("element at 1st index: "+list.get(1));

        //clear : removes all the elements output : []

        list.clear();
        System.out.println(list);


        // //replace the element 
        // list.set(2,1000);  //index, value 
        // System.out.println(list);

        

         


    }
    
}

/*
 if removing elements in between then the elements shift accordingly 

 TC: O(n), works internally  
 */