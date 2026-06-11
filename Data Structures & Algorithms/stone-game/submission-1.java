class Solution {
     private int ss[],dp[][];

public int maxScore(int start,int end){
    if(end<start) return 0;
    
   int ans=Integer.MIN_VALUE;

   if(dp[start][end+1]!=Integer.MIN_VALUE)return dp[start][end+1];

   if(start<ss.length)
   ans=Math.max(ans,ss[start]-maxScore(start+1,end));

    if(end>-1)
   ans=Math.max(ans,ss[end]-maxScore(start,end-1));
return (dp[start][end+1]=ans);
}

   public boolean stoneGame(int[] piles) {
        
ss=piles;
int n=piles.length;
dp=new int[n+2][n+2];

for(int i=0;i<n+2;i++)
    Arrays.fill(dp[i], Integer.MIN_VALUE);
return maxScore(0, piles.length-1)>0;


    }

}