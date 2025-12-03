
/*
 Q5. Given a string, find the first non-repeating character using a Set. 
 Input: "swiss" Output: "w"

 */

 //student code 
 import java.util.HashSet;

public class Repeat {
    public static void main(String[] args) {
        String s = "swiss";
        System.out.println(firstNon(s));
    }

    public static char firstNon(String str) {
        HashSet<Character> seen = new HashSet<>();
        HashSet<Character> dup = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (seen.contains(c)) dup.add(c);
            else seen.add(c);
        }

        for (char c : str.toCharArray()) {
            if (!dup.contains(c)) return c;
        }

        return '\0';
    }
}

//student code


// import java.util.*;

// public class FirstNonRepeating {
//     public static void main(String[] args) {
//         String str = "swiss";
//         Set<Character> seen = new HashSet<>();
//         Set<Character> repeating = new HashSet<>();

//         for (char c : str.toCharArray()) {
//             if (!seen.add(c)) { 
//                 repeating.add(c);
//             }
//         }

//         for (char c : str.toCharArray()) {
//             if (!repeating.contains(c)) {
//                 System.out.println("Output: " + c);
//                 break;
//             }

//         }

//     }
// }