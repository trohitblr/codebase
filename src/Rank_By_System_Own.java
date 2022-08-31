import java.util.Arrays;
import java.util.Comparator;

public class Rank_By_System_Own {

    public static void rankTeams(String[] votes) {

        int n = votes.length;

        int teams = votes[0].length();

        int [][] cnt = new int[26][teams+1];

        for(int i=0; i<n;i++){
            for(int j=0; j<teams;j++){

                int val = votes[i].charAt(j) -'A';
                cnt[val][j] += 1;
                cnt[val][teams] = - (val+65);
            }
        }


        for(int i=0; i<teams;i++){
            System.out.println(Arrays.toString(cnt[i]));
            System.out.println();
        }

        Arrays.sort(cnt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               for(int i=0;i<o1.length;i++){

                   if(o1[i] > o2[i]){
                       return -1;
                   }else if(o1[i] < o2[i]){
                       return 1;
                   }
               }
               return 0;
            }
        });

        for(int i=0; i<teams;i++){
            System.out.println(Arrays.toString(cnt[i]));
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< teams;i++){
            int tmp = -(cnt[i][teams]);
            sb.append((char)tmp);
        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        String [] votes = {"ABC","ACB","ABC","ACB","ACB"};
        rankTeams(votes);

        System.out.println();
    }
}
