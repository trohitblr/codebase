import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Cache(2)
//        push(1)
//        push(2)
//        get(1)
//        push(3)
//        Cache - 1,3


// O(1)
// Cache(5)
//* push(key, value)
//* get(key)
//* remove(key)


//Cache(2)
//        push(1,rohit)
//        push(2, arvind)
//        push(3, shiva)
//       Cache - 2,3

// 2
//  arvind shiva
public class LRUCache {


    int capacity;
    private Deque<String> dq;
    Map<String,String> hm;


    public LRUCache(int capacity){
        this.capacity=capacity;
        hm = new HashMap<String,String>();
        dq = new LinkedList<>();
    }


    // 1 2 3
    //3 2
    public void push(String key, String value){
      //  if(!hm.containsKey(key)) {
            if (dq.size() == capacity) {
                String last_element = dq.removeLast();
                hm.remove(last_element);
            }
         //   }
       /* }else if(dq.size() == capacity){
            String last_element = dq.removeLast();
            hm.remove(last_element);
        }*/
            hm.put(key,value);
            dq.addFirst(key);

    }

    public String get(String key){
        String value="Not Available";
        if (hm.containsKey(key)){
            value =  hm.get(key);
            dq.remove(key);
            dq.addFirst(key);
        }
        return value;
    }


    public void remove(String key){
        if (hm.containsKey(key)){
             hm.remove(key);
            dq.remove(key);
        }
    }

  public void printKeys(){
       Deque<String> dq1 = new LinkedList<>(dq);
        while(!dq1.isEmpty()){
            System.out.println(dq1.poll()+" ,");
        }

  }

  public static void main(String [] args){

      LRUCache lru = new LRUCache(2);

      lru.push("1","Rohit");
      lru.push("2","Arvind");
      lru.push("1","Arvind");
      lru.push("3","Shiva");


      // 1  1.1
    //  2  1.12
    //  1  1.13
      // R 1


    //  lru.remove("2");
     // System.out.println(lru.get("1"));

      System.out.println(lru.get("1"));

      // System.out.println(lru.get("1"));

      lru.printKeys();




      /*
      push(1, "Rohit")
   push(2, "Arvind")
   push(1, "Arvind")
   push(3, "Shiva")
   get(1) - "Arvind"
       */

     //  3 1


/*
      push(1, "Rohit")
      push(2, "Arvind")
      push(1, "Rohit")
      push(3, "Shiva")
      get(1) - "Rohit"
*/
      // 1 3

    //  push(1, "Rohit")
    //  push(2, "Arvind")
    //  remove(2)
   //   push(3, "Shiva")
   //   get(2) - "Arvind"

     //     3 1 :-




// 1 3

    /*  Cache(2)
      push(1, "Rohit")
      push(2, "Arvind")
      get(1)
      push(3, "Shiva")
      get(1) - "Rohit"
     */


      // lru.printKeys();

// 1st case
      //Cache(2)
//        push(1,rohit)
//        push(2, arvind)
//        push(3, shiva)
//       Cache - 2,3

// 2nd case
      // Cache(2)
//        push(1)
//        push(2)
//        get(1)
//        push(3)
//        Cache - 1,3


      // 3rd case :- Done
      //Cache(2)
//        push(1,rohit)
//        push(2, arvind)
//        push(3, shiva)
//       Cache - 2,3

  }

}
