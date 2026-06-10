class Solution {
private int[][] dp;

private int getProfit(int ind,boolean flag,int[] prices){
    int ans=0;
    if(ind>=prices.length)return 0;
    int bit = (flag ? 1 : 0);
   
   if(dp[bit][ind]!=Integer.MIN_VALUE)return dp[bit][ind];

if(flag){
ans = Math.max(prices[ind]+getProfit(ind+2,false,prices),
          0);
          ans = Math.max( getProfit( ind+1, true, prices),
          ans);
}else{
ans = Math.max(-prices[ind]+getProfit(ind+1,true,prices),0);

ans = Math.max(getProfit(ind+1,false,prices),ans);

}

return (dp[bit][ind]=ans);

}


 public int maxProfit(int[] prices) {
     dp = new int[2][prices.length];
     Arrays.fill(dp[0], Integer.MIN_VALUE);
     Arrays.fill(dp[1],Integer.MIN_VALUE);
return getProfit(0,false,prices);

    }
}
