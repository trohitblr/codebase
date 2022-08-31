import java.util.Arrays;

public class Rank_Teams_by_Votes {

    public static String rankTeams(String[] votes) {
        int len = votes.length;
        int teams = votes[0].length();
        if (len == 1 || teams == 1)  // only one team or only one vote
            return votes[0];

        int[][] cnt = new int[26][teams + 1];
        for (int i = 0; i < len; i++) {
            int val = 0;
            for (int j = 0; j < teams; j++) {  // rank in this vote
                val = votes[i].charAt(j) - 65;  // 65 is the ascii value of 'A'
                cnt[val][j] += 1;
                cnt[val][teams] = -(val + 65);
             /*   for (int k = 0; k < teams; k++) {
                    System.out.println(Arrays.toString(cnt[k]));
                }*/
            }
        }

        // debug
        for (int i = 0; i < teams; i++) {
          System.out.println(Arrays.toString(cnt[i]));
        }

        Arrays.sort(cnt, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                System.out.println("a");
                System.out.println(Arrays.toString(a));
                System.out.println("b");
                System.out.println(Arrays.toString(b));
                for (int i = 0; i < a.length; i++) {
                    if (a[i] > b[i])
                        return -1;
                    else if (a[i] < b[i])
                        return 1;
                }
                return 0;  // not gonna happen
            }
        });

        // debug
         for (int i = 0; i < teams; i++) {
           System.out.println(Arrays.toString(cnt[i]));
         }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams; i++) {
            int tmp = -cnt[i][teams];
            char c = ((char) tmp);
            sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
      String [] votes = {"ABC","ACB","ABC","ACB","ACB"};

      System.out.println(rankTeams(votes));
    }
}
