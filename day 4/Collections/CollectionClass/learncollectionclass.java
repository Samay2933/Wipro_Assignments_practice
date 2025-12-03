import java.util.*;

public class learncollectionclass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(34,12,9,9,9,79,29,75));

        System.err.println(list);
        

        //min , max 
        System.out.println("min element: "+ Collections.min(list));
        System.out.println("max element: "+ Collections.max(list));
        
        //frequency 
        System.out.println("Frequency of a 9: "+Collections.frequency(list, 9));

        Collections.sort(list);  //list, Comparator.reverseOrder()
        System.out.println(list);
        


    }
    
}
