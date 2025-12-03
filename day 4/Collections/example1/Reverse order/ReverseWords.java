/*
 Q3. Given a list of strings, write a program to reverse the order of words in the list and also reverse each word
itself. Input: ["Java", "is", "fun"] . Output: ["nuf", "si", "avaJ"]
 */

import java.util.*;

public class ReverseWords {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>(Arrays.asList("Java", "is", "fun"));
        List<String> outputList = new ArrayList<>();

        // willl Iterate from end to start to reverse order
        for (int i = inputList.size() - 1; i >= 0; i--) {
            String word = inputList.get(i);
            String reversedWord = new StringBuilder(word).reverse().toString();
            outputList.add(reversedWord);
        }

        System.out.println("Input List: " + inputList);
        System.out.println("Output List: " + outputList);
    }
}
