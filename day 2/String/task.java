public class task {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(s1);
        String s2 = "World";
        String s4 = s1.concat(" ").concat(s2);
        System.out.println(s4);
        char c = s1.charAt(4);
        System.out.println(c);
        int pos1 = s4.indexOf("o");
        System.out.println(pos1);
    }
    
}
