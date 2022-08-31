
// method return int  it will take sorted array as a argument
// remove the duplicate array return count of the array

// O(n) - > 1 2 3 3 4 5 6


// method takes head of the linked list and return middle node of the linked list
public class TestClas {

/*
    public static int getOriginalCount(int [] arr){

        int count =0;
        if(arr == null ){
            return 0;
        }

        if(arr.length == 1){
            return 1;
        }


        int prev = arr[0];
        count++;

        for(int i=1;i<arr.length;i++){
             if(arr[i] != prev){
                 count++;
                 prev = arr[i];
             }
        }

        return count;
    }
*/

   // LinkNode
     // 1 2 3 4 5 6  :- 3
    // 1 2 3 4 :- 2
    // 1 2 3 4 5 - > 3
    // hare
    // tortoris

    public static int getMidElement(LinkNode head){

        LinkNode hare = head;
        LinkNode tortoris = head;


        while( hare != null  && hare.next != null /*&& hare.next.next != null*/){

            hare = hare.next.next;
            tortoris = tortoris.next;
        }
        return tortoris.data;
    }




    public static void main(String[] args) {


       // int [] arr = {1,2,3,3,4,4,4,5,5,6,7,7};

       // System.out.println(getOriginalCount(arr));

        LinkNode ll1 = new LinkNode(1);
        LinkNode ll2 = new LinkNode(2);
        LinkNode ll3 = new LinkNode(3);
        LinkNode ll4 = new LinkNode(4);
        LinkNode ll5 = new LinkNode(5);
        LinkNode ll6 = new LinkNode(6);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;
       // ll5.next = ll6;

      System.out.println(getMidElement(ll1));


    }
}
