import java.util.*;
/*
 Write a Java function that takes an integer and prints whether it is even or odd.
 */

public class p2 {
    
    public static void check(int n){
        if(n%2 == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }
    
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();

        check(n);

        sc.close();

    }
}