public class primitive {
    public static void main(String[] args) {
        int a = 10;
double b = a; // int -> double (safe, automatic)
System.out.println(b); // 10.0
    

    double x = 9.7;
int y = (int) x; // double -> int (need cast, decimals lost)
System.out.println(y); // 9
}
    
}
