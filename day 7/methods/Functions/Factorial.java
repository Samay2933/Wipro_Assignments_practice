import java.util.Scanner;
/*
 Write a Java function to find the factorial of a given number.
 */
public class Factorial {
    public static long fact(int n) {

        if(n <0){
            System.out.print("Error\n");
            return -1;
        }
        if(n == 0 || n == 1){
            return 1;
        }

        long result = 1;
        for(int i= 2; i<=n; i++){
            result = result*i;
        }
        return result;    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        long res = fact(n);
        System.out.println("Answer is : "+res);
    
    sc.close();
    }
}