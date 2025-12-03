import java.util.*;

public class HashMapDemo{
    public static void main(String[] args) {
        HashMap<String,Integer> numbers = new HashMap<>();

        numbers.put("One",1);
        numbers.put("Two",2);
        numbers.put("Three",3);
        
        //numbers.put("Two",23);  //overwrites it , and doesnt make copy

        System.out.println(numbers);

        //check
        // if(numbers.containsKey("Two")){
        //     numbers.put("Two",23);
        // }

        numbers.putIfAbsent("Two", 23); //if key is missing then add else not 

        //removes 
        //numbers.remove("Three");  //removes by the key value

        System.out.println(numbers);

        System.out.println(numbers.isEmpty());

        for(String key: numbers.keySet()){
            System.out.println(key);
        }

        for(Integer value: numbers.values()){
            System.out.println(value);
        }


    }
    
}