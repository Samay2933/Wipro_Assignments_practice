// public class test {
//     public static void main(String[] args) {
//         int num = 10;
//         Integer number= num;
//         System.out.println("Autoboxing: "+number);

        
//     int newNum = number;
//     System.out.println("boxing: "+ newNum);
//     }

    
// }


public class test {
    public static void main(String[] args) {
        int num = 10;
        Integer number= Integer.valueOf(num);
        System.out.println("Autoboxing: "+number);

        HashMap<String, Int> map = new HashMap();
        
    int newNum = number;
    System.out.println("boxing: "+ newNum);
    }
}
