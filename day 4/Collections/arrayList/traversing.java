import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class traversing {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(list);

        for(int i=0; i<list.size();i++){
            System.out.println("the element is : "+list.get(i));

        }
        
        //recommmended 
        //for each loop
        //for(datatype variable_name : inlist )
        for(Integer element: list){ 
            //element valriable name , 
            System.out.println("the element is : "+element);
        }

        //iterator 
        Iterator<Integer> it = list.iterator();
        //has functionality under its 
        while(it.hasNext()){
            System.out.println("iterator "+it.next());
        }
    }
}
