import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
//perform all the operations using these : 
//student code 

public class SetsFull {
public static void main(String[] args) {
        
        Set<String> hashSet = new HashSet<>();
       
        System.out.println("Add null (1st attempt): " + hashSet.add(null));
        System.out.println("Add null (2nd attempt): " + hashSet.add(null));
        System.out.println("Final HashSet size: " + hashSet.size() + "\n");

        Set<String> linkedHashSet = new LinkedHashSet<>();
        
        System.out.println("Add null (1st attempt): " + linkedHashSet.add(null));
        System.out.println("Add null (2nd attempt): " + linkedHashSet.add(null));
        System.out.println("Final LinkedHashSet size: " + linkedHashSet.size() + "\n");
        
        Set<String> treeSet = new TreeSet<>();
       
        
        treeSet.add("Example");
        System.out.print("Attempting to add null: ");
        
        treeSet.add(null);
}
}