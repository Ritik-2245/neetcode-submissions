class Solution {

public int lengthOfLIS(int[] nums) {
        // arr=nums,sz=nums.length;
        // return LTS(0,-1);
int n = nums.length;
int[][] dp = new int[n+1][n+1];

    for(int ind=n-1;ind>=0;ind--){
        for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){
              int len = dp[ind+1][prev_ind+1];
              if(prev_ind ==-1 || nums[ind]>nums[prev_ind])
                len = Math.max(len,1+dp[ind+1][ind+1]);
            dp[ind][prev_ind+1]=len;

        }
    }  
return dp[0][0];

    }

}
