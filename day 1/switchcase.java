import java.util.Scanner;
public class switchcase {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);

        System.out.print("Enter a number(1-3) : ");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
            System.out.println("You choose one");
            break;
            case 2:
            System.out.println("You choose two");
            break;
            case 3:
            System.out.println("You choose three");
            break;

            default:
            System.out.println("NOTA");
            break;
        }

    }
    
}
