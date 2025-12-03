//student code
import java.util.HashMap;
import java.util.Map;
/*
 Count how many times each word appears in a given string. 
 Input: "What a beautiful day it is with a beautiful weather"
 */
public class CountWords {
    public static void main(String[] args) {
        String arr = "What a beautiful day it is with a beautiful weather";
        String[] words = arr.split(" ");
        HashMap<String,Integer> hm =new HashMap<>();
        for(String word : words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry: hm.entrySet()){
                System.out.println(entry.getKey() + " -> "+ entry.getValue());

        }
    }
}