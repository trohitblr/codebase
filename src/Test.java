import java.util.ArrayList;
import java.util.List;

public class Test {

    // 100 100 200
    // count 2

    public void populate(List ll){
        if(null == ll){
            ll= new ArrayList();
        }

       for(int i=0; i<5;i++){
           ll.add(i);
       }
        System.out.println(ll);
    }

    public static void main(String[] args) {

        Test t = new Test();
        List ll = null;
       // List ll = new ArrayList();
        t.populate(ll);
        System.out.println(ll);


        ArrayList<Integer> arr = new ArrayList();

        arr.add(2);
        arr.add(3);
        arr.add(5);

        System.out.println(arr);
        arr.remove(arr.indexOf(2));
        System.out.println(arr);

    }

}
