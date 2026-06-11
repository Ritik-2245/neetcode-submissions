class Solution {
   public boolean stoneGame(int[] piles) {
        
// ss=piles;
int n=piles.length;
// dp=new int[n+2][n+2];

// for(int i=0;i<n+2;i++)
//     Arrays.fill(dp[i], Integer.MIN_VALUE);
// return maxScore(0, piles.length-1)>0;

    int[][] dp = new int[n][n];
        
        for(int i=0;i<n;i++)
            dp[i][i]=piles[i];

        for(int l=2;l<=n;l++){
           for(int start=0;start+l-1<n;start++){
            int end=start+l-1;
            dp[start][end]=Math.max(piles[start]-dp[start+1][end],piles[end]-dp[start][end-1]);
           }


        }
return dp[0][n-1]>0;


    }


}