import java.util.*;
// public class replace {
//     public static void main(String[] args) {
//         String old = "Hello? World?";
//         String newstring = old.replace('?', '!');
//         System.out.println(newstring); // Output: Hello! World!
//     }
// }

class fish{

    String original;
    String oldchar;
    String newchar;
    String updated;

    fish(){
        System.out.println("Default constructor");
    }

    fish(String original,String oldchar,String newchar){
        this.original = original;
        this.oldchar = oldchar;
        this.newchar = newchar;

        //Perform replacement 
        this.updated = original.replace(oldchar, newchar);

    }

    void display(){
        System.out.println("old word: "+ original );
        System.out.println("New word: "+ updated);
    }

}

public class replaceChar{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String original = sc.nextLine();
        System.out.println("What character to replace: ");
        String oldchar = sc.nextLine();
        System.out.println("Replace with: ");
        String newchar = sc.nextLine();

        fish f = new fish(original, oldchar, newchar);

        f.display();

        sc.close();
    }
}