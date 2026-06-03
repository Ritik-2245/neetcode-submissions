class Solution {
private int optiamLSolution(int ind,int[] val,int[] dp){
 if(ind>=val.length)return 0;
 int sum=0,best=Integer.MIN_VALUE;

 if(dp[ind]!=Integer.MIN_VALUE)return dp[ind];

 for(int i=0;i<3 && i+ind<val.length;i++){
    sum+=val[i+ind];

    best = Math.max(best,sum-optiamLSolution(i+ind+1,val,dp));
 }
 return (dp[ind]=best);
  
}



public String stoneGameIII(int[] stoneValue) {
     int[] dp = new int[stoneValue.length];
     Arrays.fill(dp,Integer.MIN_VALUE);
    int p= optiamLSolution(0,stoneValue,dp);

    if(p>0)return "Alice";
    else if(p<0)return "Bob";
    else return "Tie";

    }

}