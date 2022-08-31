public class MinimumCOstDuringStay {


    public static void costCalculation(int [][] fare, int shift){

        int row = fare.length;
        int col = fare[0].length;

        int [][] calFare = new int[row][col];


        for(int i=0; i< row;i++){
            int pre = 0;
            for(int j=col-1; j>=0;j--){
                calFare[i][j] = pre+fare[i][j];
                pre = calFare[i][j];
            }
        }

        printMatrix(fare);
        System.out.println();
        printMatrix(calFare);

    }


public static void printMatrix(int [][] mat){
    int row = mat.length;
    int col = mat[0].length;
        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                System.out.print(mat[i][j]+ " , ");
            }
            System.out.println();
        }

}


public static void finMin(int [][] arr ,int [][] mat, int k){
    int row = arr.length;
    int col = arr[0].length;


    int min = Integer.MIN_VALUE;

    for(int i=0; i<row;i++){

        for(int j=0; j<col;j++) {

        }
        }


}

public static int min(int [][] arr ,int [][] mat, int k, int i, int j, int curr_sum){

        int row = arr.length;
    int col = arr[0].length;
    int currcol =j;
    int currrow =0;



    while(k>1 && currcol < col && currrow < row){

       int min =Integer.MAX_VALUE;

        int fir = arr[currrow][currcol+1];
        int sec = arr[currrow+1][currcol+1];
        int thir = arr[currrow+2][currcol+1];

        if(sec < thir){
            min =  sec;
            currcol = currcol+1;
            currrow= currrow+1;
        }else{
            min =  thir;
            currcol = currcol+1;
            currrow= currrow+2;
        }

        if(fir < min){
            min =  fir;
            currcol = currcol;
        }
        curr_sum = curr_sum+min;
    }



        return curr_sum;
}


    public static void main(String [] args){

        int [][] fare = new int[][] {{1000,1100,900},{1200,900,600},{1500,1000,600}
        };

        costCalculation(fare,2);


       // duration -> 10th - 12th ..

      //  hotel1 -> 1000 1100 900
      //  hotel2 -> 900  1200 1500
      //  hotel3 -> 1500 1000 1000
    }
}
