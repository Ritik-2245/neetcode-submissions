class Solution {
public String stoneGameIII(int[] stoneValue) {
    //  int[] dp = new int[stoneValue.length];
    //  Arrays.fill(dp,Integer.MIN_VALUE);
    // int p= optiamLSolution(0,stoneValue,dp);

    // if(p>0)return "Alice";
    // else if(p<0)return "Bob";
    // else return "Tie";

   int[] dp = new int[3];
int n=stoneValue.length;
   for(int ind=n-1;ind>=0;ind--){
    int sum =0,best=Integer.MIN_VALUE;
      for(int i=0;i<3 && i+ind<n;i++){
        sum+=stoneValue[i+ind];
        best=Math.max(best,sum-dp[i]);
      }
      dp[2]=dp[1];
      dp[1]=dp[0];
      dp[0]=best;

   }

 if(dp[0]>0)return "Alice";
    else if(dp[0]<0)return "Bob";
    else return "Tie";



    }

}