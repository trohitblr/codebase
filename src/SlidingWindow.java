import java.util.*;

// print sliding window
//  sliding window with k unique numbers
// max in each sliding window

public class SlidingWindow {

    // print sliding window
    public static void printEachSlidingWinow(int [] arr, int k){
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length;

        for(int i=0; i<k ;i++){
            al.add(arr[i]);
        }
        System.out.println(al);
        for(int i= k; i<n ;i++){
            al.remove(0);
            al.add(arr[i]);
            System.out.println(al);
        }
    }


    //  sliding window with k unique numbers
    public static void printKUniquSlidingWinow(int [] arr, int k){

        int min_length =Integer.MAX_VALUE;
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
     //   int topcount =0;
        int m =0;
        int i;
        for( i =0;i<arr.length;i++){

            if(m ==k){
                break;
            }

            if(hm.containsKey(arr[i])){
                int count = hm.get(arr[i]);
                hm.put(arr[i],count+1);
            }else{
                hm.put(arr[i],1);
                m++;
            }
           // topcount++;
            al.add(arr[i]);
        }

       // System.out.println("al " + al +" i" +i);
      //  System.out.println("hm " + hm);

      //  System.out.println("min Length " + findSmallLength(al,hm));

        int curr_min = findSmallLength(al,hm);
        if(min_length > curr_min){
            min_length = curr_min;
        }

       // System.out.println("al " + al +" i" +i);
       // System.out.println("hm " + hm);

        int t = hm.keySet().size();
    int s = i;
      //  for(int s =i+1 ;s<n;s++){
        while(s<n){
           // System.out.println("al from " + al +" s" +s);
           // System.out.println("hm from " + hm);
            if(hm.keySet().size() == k){
                curr_min = findSmallLength(al,hm);
                if(min_length >= curr_min){
                    min_length = curr_min;
              //      System.out.println("min_Length " + min_length);
                }
                if(hm.containsKey(arr[s])){
                    int count = hm.get(arr[s]);
                    hm.put(arr[s], count+1);
                }else{
                    hm.put(arr[s], 1);

                }
                al.add(arr[s]);
                s++;

               // System.out.println("al in " + al +" s" +s);
               // System.out.println("hm in " + hm);

            }else{
                if(hm.get(al.get(0)) > 1){
                    int count = hm.get(al.get(0));
                    hm.put(al.get(0), count-1);

                }else{
                    hm.remove(al.get(0));

                }
                al.remove(0);
            }
        }

        System.out.println("min_Length " + min_length);

    }

    public static int findSmallLength(ArrayList<Integer> al, HashMap<Integer,Integer> hm){


       // System.out.println("al " + al );
       // System.out.println("hm --- " + hm);

        int n= al.size();
        int max_length = n;
        int i=0;
        while(i<n){


            if(hm.get(al.get(0)) > 1){
                int num = al.get(0);
              //  System.out.println("num ---" + num );
                int count = hm.get(num);
                hm.put(num ,count-1);
                al.remove(0);
            }else{
               // hm.remove(al.get(0));
                break;
            }
           // System.out.println("al ---9" + al );
           // System.out.println("hm ---9 " + hm);
            i++;

        }
        if(max_length > al.size()){
            max_length = al.size();
        }
      //  System.out.println("max_length ---from return " + max_length );
        return max_length;
    }


    // max in each sliding window
    public static void maxIneachSlidingWindow(int [] arr , int k){

        int n = arr.length;

        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i=0; i<k;i++){

            while(!q.isEmpty() && arr[q.getLast()] < arr[i]){
                q.removeLast();
            }
                q.addLast(i);

        }

      //  System.out.println( arr[q.getFirst()]);


        for(int l=i;l<n;l++){

            System.out.print( arr[q.getFirst()] +" ,");

            if(q.getFirst()+k == l){
                q.removeFirst();
            }

            while(!q.isEmpty() && arr[q.getLast()] < arr[l]){
                q.removeLast();
            }

            q.addLast(l);

        }

        System.out.println( arr[q.getFirst()] );



    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8};
       int k =3;
        printEachSlidingWinow(arr,k);

        int [] arr1 = {2,2,1,1,3,3,4,4,5,5};
        //int k =3;

        printKUniquSlidingWinow(arr1,k);

        int [] arr2 = {3,2,1,4,2,1,0,4,1,7};
        maxIneachSlidingWindow(arr2,k);
    }
}
