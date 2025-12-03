//student code 


/*
 Q4. Check if two lists have no elements in common using a Set.
  List1: [1, 2, 3] List2: [4, 5, 6]
   Output: true

 */
import java.util.HashSet;

public class CheckCommon {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);
        HashSet<Integer> set2 = new HashSet<>();
        
        set2.add(40);
        set2.add(50);
        set2.add(60);

        HashSet<Integer> res = new HashSet<>();
        res.addAll(set1);
        res.addAll(set2);

        boolean result = ((set1.size() + set2.size()) - res.size()) == 0;
        System.out.println("no elements in common: "+result);
    }
}