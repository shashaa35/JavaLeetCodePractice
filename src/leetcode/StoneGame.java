package leetcode;

//dp[i][j] represents maximum possible sum we can get by playing first in the array [i,i+1....j]
//ref:https://www.youtube.com/watch?v=ww4V7vRIzSk
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        long total =0;
        for (int p:piles)
            total += p;

        int dp[][] = new int[piles.length][piles.length];
        for (int gap = 0;gap<dp.length;gap++) {
            for (int i=0, j =gap;j<dp.length;i++,j++) {
                if (gap == 0) {
                    dp[i][j] = piles[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.max(piles[i], piles[j]);
                } else {
                    // we pick i --> [i+1,j] is left
                    // opponent picks i+1 --> [i+2,j] is left
                    // opponent picks j --> [i+1,j-1] is left
                    // opponent picks such that he left us with minimum of [i+2,j] or [i+1,j-1]
                    int ifWePickI = piles[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);

                    // we pick j --> [i,j-1] is left
                    // opponent picks i --> [i+1,j-1] is left
                    // opponent picks j-1 --> [i,j-2] is left
                    // opponent picks such that he left us with minimum of [i+1,j-1] or [i,j-2]
                    int ifWePickJ = piles[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                    dp[i][j] = Math.max(ifWePickI, ifWePickJ);
                }
            }
        }
        long alexScore = dp[0][piles.length-1];
        long leeScore = total - alexScore;
        return alexScore > leeScore;
    }
}
