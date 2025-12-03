import java.util.*;
/*
 
Q3. Given a string, count the number of unique words using a Set. 
Input: "Java is fun and Java is powerful"

 */ //student code 


public class UniqueWords {
    public static void main(String[] args) {
        String input = "Java is fun and Java is powerful";
        String[] words = input.toLowerCase().split("\\s+");//when ever there is space new word will count

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Count: " + uniqueWords.size());
    }
}

 /*
  split(...)
A method of the String class that takes a regular expression (regex) as the separator.

\\s
In regex, \s means any whitespace character (space, tab, newline, etc.).
In Java strings, backslashes must be escaped, so \\s is needed.

+
Regex quantifier meaning "one or more" of the preceding element.

"\\s+"
Matches one or more whitespace characters in a row.
  */