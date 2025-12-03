//student code
import java.util.HashMap;
import java.util.Map;
/*
 Merge two maps and if a key exists in both, add their values. 
 Map1 = {a=10, b=20, c=30}. Map2 = {b=15, c=25, d=35}. 
 Output = {a=10, b=35, c=55, d=35}
 */
public class Map_Val_Sum {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 10);
        map1.put("b", 20);
        map1.put("c", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 15);
        map2.put("c", 25);
        map2.put("d", 35);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map1.put(entry.getKey(),
                    map1.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        System.out.println("Merged Map: " + map1);
    }
}