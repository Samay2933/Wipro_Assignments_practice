public class oddevencount {
    public static void main(String[] args) {
        int[] num ={2,5,8,9,12,15,20};

        int Oddcount=0;
        int Evencount=0;

        for(int i=0;i<num.length;i++){
            if(num[i] % 2==0){
                Evencount++;
            }else{
                Oddcount++;
            }
        }

        System.out.println("Number of Even numbers : "+Evencount);
        System.out.println("Number of Odd numbers: "+Oddcount);
    }
}