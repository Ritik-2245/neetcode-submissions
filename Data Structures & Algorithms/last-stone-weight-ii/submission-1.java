class Solution {
private int getMin(int ind,int target,int sum,int[] stones,int[][] dp){

if(ind==stones.length)return Integer.MAX_VALUE;

if(dp[ind][sum]!=Integer.MAX_VALUE)return dp[ind][sum];

 int ans = Math.abs(target-2*(sum+stones[ind]));
 ans = Math.min(ans,getMin(ind+1,target,sum+stones[ind],stones,dp));
 ans = Math.min(ans,getMin(ind+1,target,sum,stones,dp));
return (dp[ind][sum] =ans);
}


 public int lastStoneWeightII(int[] stones) {
     int sum = Arrays.stream(stones).sum();
     int n=stones.length;
     int[][] dp = new int[n][sum+1];
     for(int i=0;i<n;i++)
        Arrays.fill(dp[i], Integer.MAX_VALUE);
return getMin(0, sum, 0, stones,dp);
    }

} 