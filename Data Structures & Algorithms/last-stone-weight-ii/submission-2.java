class Solution {
 public int lastStoneWeightII(int[] stones) {
     int sum = Arrays.stream(stones).sum();
     int n=stones.length;
     boolean[][] dp = new boolean[sum+1][n+1];
//      for(int i=0;i<n;i++)
//         Arrays.fill(dp[i], Integer.MAX_VALUE);
// return getMin(0, sum, 0, stones,dp);

Arrays.fill(dp[0],true);

int ans =Integer.MAX_VALUE;

for(int i=1;i<=n;i++){
    for(int s=0;s<=sum;s++){
        dp[s][i]=dp[s][i-1];
        if(stones[i-1]>s)continue;
        dp[s][i] |= dp[s-stones[i-1]][i-1];

        if(dp[s][i]){
            ans = Math.min(ans, Math.abs(sum-2*s));
        }
    }
}
   return ans;

    }

} 