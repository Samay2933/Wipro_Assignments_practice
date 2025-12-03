import java.util.*;
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);
        System.out.println(sb.append("World"));
        
        System.out.println(sb.insert(5,","));
        
        System.out.println(sb.deleteCharAt(5));
        
        System.out.println(sb.replace(0,5,"hey"));
        System.out.println(sb.reverse());
        
    }
}
