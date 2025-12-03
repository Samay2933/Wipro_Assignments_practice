
import java.util.*;
/*
 Find all characters that appear more than once in a string. 
 Input: "programming". 
 Output: {r=2, g=2, m=2}
 */
public class Char_Count {
    public static void main(String[] args) {
        String s = "programming";
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(Character c: ch){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry: hm.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey() + " -> "+ entry.getValue());
            }

        }
    }
}