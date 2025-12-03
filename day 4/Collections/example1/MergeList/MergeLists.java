import java.util.*;
/*
 
Q5. Merge two lists, remove duplicates, and sort in ascending order. List 1: [3, 5, 7, 5] . List 2: [2, 7, 8, 3].
Output : [2, 3, 5, 7, 8]

 */
public class MergeLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3, 5, 7, 5);
        List<Integer> list2 = Arrays.asList(2, 7, 8, 3);

        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        // Remove duplicates by using a LinkedHashSet to maintain insertion order
        Set<Integer> set = new LinkedHashSet<>(mergedList);

        // Convert back to list and sort
        List<Integer> resultList = new ArrayList<>(set);
        Collections.sort(resultList);

        System.out.println(list1);
        System.out.println(list2);

        System.out.println("Merged and sorted list without duplicates: " + resultList);
    }
}
