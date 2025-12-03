//student code 

import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> animals = new LinkedHashSet();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        System.out.println(animals);
        animals.remove("Cat");
        System.out.println(animals);
        System.out.println("Size: " + animals.size());
        System.out.println(animals.contains("Dog"));
        animals.clear();
        System.out.println("After clear(): " + animals);
    }
}