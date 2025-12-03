import java.util.*;

/*
 Q4. Given a list of integers, write a Java program to find the second largest number.

 */
public class SecondLargestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 5, 40, 25, 40, 30);

        // Convert list to set to remove duplicates
        Set<Integer> set = new HashSet<>(numbers);

        // Convert back to list and sort in descending order
        List<Integer> uniqueList = new ArrayList<>(set);
        Collections.sort(uniqueList, Collections.reverseOrder());

        if (uniqueList.size() < 2) {
            System.out.println("No second largest number available.");
        } else {
            int secondLargest = uniqueList.get(1);
            System.out.println("Second largest number is: " + secondLargest);
        }
    }
}


