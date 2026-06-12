class Solution {
private int dp[][],ar[];

public int getmax(int ind,int M){
   if(ind==ar.length)return 0;
  int tmp =0;
  if(dp[ind][M]!=Integer.MIN_VALUE)return dp[ind][M];
   int ans=Integer.MIN_VALUE;
  for(int x=0;x<2*M && x+ind<ar.length;x++){
     tmp+=ar[x+ind];
     ans=Math.max(ans,tmp-getmax(ind+x+1,Math.max(x+1,M)));
  }
return (dp[ind][M]=ans);
}


public int stoneGameII(int[] piles) {

    int sum = Arrays.stream(piles).sum();
    ar=piles;
  dp = new int[piles.length][2*piles.length+1];
  for(int i=0;i<piles.length;i++)
    Arrays.fill(dp[i], Integer.MIN_VALUE);
    int s = getmax(0, 1);

    int score = (sum+s)>>1;
        
        return score;
    }



}