import java.util.HashSet;

/*
 add, remove, size, contains, clear 
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();

        //Set<Integer> s1 = new HashSet<>(); //is also correct

        //add
        s1.add(4);
        s1.add(6);
        s1.add(3);
        s1.add(2);
        s1.add(4);
        //random roder elements print, coz hashing is going on inside 

        System.out.println("List is: "+s1);
        System.out.println("Before Removing Size is: "+s1.size());

        //remove 
        s1.remove(3);
        System.out.println("after removing: "+ s1);
        System.out.println("After Removing Size is: "+s1.size());

        //contains
        System.out.println("Does this set contains 3: " + s1.contains(3));
        System.out.println("Does this set contains 4: " + s1.contains(4));

        //clear 
        s1.clear();
        System.out.println("List after clear: "+s1);

        System.out.println("Set empty? : "+s1.isEmpty());
    }
}

/**
 import java.util.*;
    
public class Set_two{
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();

        //add

        s1.add(10);
        s1.add(20);
        s1.add(30);
        System.out.println(s1);

        //remove
        s1.remove(30);
        System.out.println(s1);

        //contains 
        s1.contains(20);
        System.out.println(s1.contains(20));

        //clear
        s1.clear();
        System.out.println(s1);

    }
    
}
//self practice 
 */


