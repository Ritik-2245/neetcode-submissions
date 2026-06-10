class Solution {
 public int lastStoneWeightII(int[] stones) {
     int sum = Arrays.stream(stones).sum();
     int n=stones.length;
     boolean[] dp = new boolean[sum+1];
    
//      for(int i=0;i<n;i++)
//         Arrays.fill(dp[i], Integer.MAX_VALUE);
// return getMin(0, sum, 0, stones,dp);

dp[0]=true;
 boolean[] temp;
int ans =Integer.MAX_VALUE;

for(int i=1;i<=n;i++){
     temp = new boolean[sum+1];
    for(int s=0;s<=sum;s++){
        temp[s]=dp[s];
        if(stones[i-1]>s)continue;
        temp[s] |= dp[s-stones[i-1]];

        if(temp[s]){
            ans = Math.min(ans, Math.abs(sum-2*s));
        }
    }
    dp=temp;
}
   return ans;

    }

} 