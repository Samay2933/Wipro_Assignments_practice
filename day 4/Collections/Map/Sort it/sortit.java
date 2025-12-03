import java.util.*;
/*
 Given a map {3=Banana, 1=Apple, 2=Cherry}, 
 Sort it: 1. by keys 2. by values
 */
public class sortit {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println("Get key 2: " + map.get(2));
        map.remove(3);
        System.out.println("Contains key 1: " + map.containsKey(1));
        System.out.println("Contains value 'Banana': " + map.containsValue("Banana"));
        System.out.println("Size: " + map.size());
        map.clear();
        System.out.println("After clear: " + map);
    }
}

