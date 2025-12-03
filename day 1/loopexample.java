import java.util.Scanner;

public class loopexample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Create Scanner object

        System.out.print("Enter how many numbers you want to sum: ");
        int count = sc.nextInt();               // Read how many numbers

        int sum = 0;                            // Variable to store total

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = sc.nextInt();             // Take input for each number
            sum += num;                         // Add to total
        }

        System.out.println("The total sum is: " + sum);

        sc.close();                             // Close scanner
    }
}
