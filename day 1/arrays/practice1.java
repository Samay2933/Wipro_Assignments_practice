import java.util.*;
public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String str1 = sc.nextLine();
        StringBuilder sb = new StringBuilder(str1);
        System.out.println(sb);
        // System.out.println(sb.append("World"));
        
        // System.out.println(sb.insert(5,","));
        
        // System.out.println(sb.deleteCharAt(5));
        
        // System.out.println(sb.replace(0,5,"hey"));
        // System.out.println(sb.reverse());

        sc.close();
        
    }
}
