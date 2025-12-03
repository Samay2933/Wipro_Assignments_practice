import java.util.Scanner;

public class addition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //Create a Scanner object to take input
        System.out.print("Enter a number: ");    // Ask the user for a number
        int num = sc.nextInt();

        num += 5;
        System.out.println(num);
        //System.out.println("Result: " + result); // Print the result

    }
    
}
