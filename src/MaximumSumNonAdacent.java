import java.util.Arrays;

public class MaximumSumNonAdacent {


    public static int max_sum(int [] arr){

        if(arr.length ==0 ){
            return 0;
        }

        if(arr.length ==1){
            return arr[0];
        }

        int inclusive = arr[0];
        int exclusive =0;

        for(int i=1;i<arr.length;i++){

            int tmp = inclusive;
            int new_incl = exclusive+arr[i];
            int inclusive_new = Math.max(new_incl,inclusive);
            exclusive = tmp;
            inclusive = inclusive_new;
        }
        return inclusive;
    }

    public static int maxSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }


    public static void main(String [] args){

        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        int arr1[] = { 10,1,1,10 };
    System.out.println(Arrays.toString(arr1));
        System.out.println(max_sum(arr1));
        System.out.println(maxSum(arr1));
    }
}
