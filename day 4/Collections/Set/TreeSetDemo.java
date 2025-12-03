//student code

import java.util.*;
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);
        set.add(25);
        System.out.println( set);
        System.out.println(set.remove(10));
        System.out.println(set.contains(15));
        System.out.println(set.size());
        set.clear();
        System.out.println(set);
    }
}