class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,(int)1e7);
         dp[0]=0;
         for(int i=1;i<=amount;i++){
                for(int a:coins){
                    if(a<=i && dp[i-a]!=(int)1e7)
                   {
                    dp[i]=Math.min(dp[i],dp[i-a]+1);
                   }
                }
         }
return dp[amount]==(int)1e7 ? -1 : dp[amount];
    }
}
