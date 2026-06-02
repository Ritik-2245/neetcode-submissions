class Solution {
  public int numSquares(int n) {
     // List<Integer> sq = new ArrayList<>();

     // for(int i=1;i*i<=n;i++)sq.add(i*i);

     int[] dp = new int[n+1];
     Arrays.fill(dp,(int)1e9);
dp[0]=0;

for(int i=1;i<=n;i++){

    for(int c=1;c*c<=i;c++){
        
            dp[i]=Math.min(dp[i],1+dp[i-c*c]);
    }
}
return dp[n];
    }

}