// public class test {
//     public static void main(String[] args) {
//         int num = 10;
//         Integer number= num;
//         System.out.println("Autoboxing: "+number);

        
//     int newNum = number;
//     System.out.println("boxing: "+ newNum);
//     }

    
// }


// public class test {
//     public static void main(String[] args) {
//         int num = 10;
//         Integer number= num;
//         System.out.println("Autoboxing: "+number);

        
//     int newNum = number;
//     System.out.println("boxing: "+ newNum);
//     }

    
// }


public class test{
    public static void main(String[] args) {
        int num = 10;
        double val = 12.5;

        Integer ob1 = Integer.valueOf(num);
        Double ob2 = Double.valueOf(val);

        System.out.println(ob1);
        System.out.println(ob2);

        int n2 = ob1.intValue();
        double v2 = ob2.doubleValue();

        System.out.println(n2);
        System.out.println(v2);
    }
}
