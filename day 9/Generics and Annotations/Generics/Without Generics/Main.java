
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw ArrayList, no type specified
        list.add("Hello");
        list.add(123); // No compile-time error

        // Retrieving and casting elements can cause runtime errors
        String str = (String) list.get(0);    // Works fine
        //String num = (String) list.get(1);  // Causes ClassCastException at runtime

        System.out.println(str);
        System.out.println(list.get(1)); // Prints 123
    }
}
