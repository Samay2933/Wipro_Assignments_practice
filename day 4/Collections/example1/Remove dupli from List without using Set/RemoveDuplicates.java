/*
 Q2. Write a Java program to remove duplicate elements from a List without using a Set. You should retain the first
occurrence of each element. Input: [10, 30, 20, 20, 10, 30, 20, 40]. Output: [10, 20, 30, 40]
 */

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>(Arrays.asList(10, 30, 20, 20, 10, 30, 20, 40));
        List<Integer> outputList = new ArrayList<>();

        for (Integer num : inputList) {
            if (!outputList.contains(num)) {  // Check if already added
                outputList.add(num);
            }
        }

        System.out.println("Original List: " + inputList);
        System.out.println("List after removing duplicates: " + outputList);
    }
}

// public class Removedupli {
//     public static void main(String[] args) {
//         List<Integer> list = new ArrayList<>(Arrays.asList(10, 30, 20, 20, 10, 30, 20, 40));
//         //List<Integer> list = Arrays.asList(10, 30, 20, 20, 10, 30, 20, 40);
//         List<Integer> output = new Removeduplicates(list);

//         System.out.println("the given list is: "+list);

//         }
//     }
    
// }

//student code 
/*
 public static List<String> revWord(List<String> words) {
    Collections.reverse(words);
    List<String> rev = new ArrayList<>();
    for (String word : words) {
        StringBuilder sb = new StringBuilder(word);
        String reversedWord = sb.reverse().toString();
        rev.add(reversedWord);
    }
    return rev;
}
 */


