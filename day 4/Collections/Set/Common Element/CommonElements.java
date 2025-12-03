import java.util.*;

/*
 Q2. Given two lists of integers, find the common elements using a Set. 
 List1: [1, 2, 3, 4], List2: [3, 4, 5, 6].
Output: [3, 4]
 */import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2); // keeps only common elements
        System.out.println("Output: " + set1);
    }
}