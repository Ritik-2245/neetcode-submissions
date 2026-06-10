class Solution {
 public int findTargetSumWays(int[] nums, int target) {
  int total = Arrays.stream(nums).sum();

  if(Math.abs(target)>total)return 0;
     int n = nums.length;
    int[][] dp = new int[n+1][2*total+1];
    // for(int i=0;i<n;i++)Arrays.fill(dp[i], -1);
  // return getComb(0, 0, target, nums);
dp[0][total]=1;
    for(int i=1;i<=n;i++){
        for(int j=0;j<=2*total;j++){
                if(dp[i-1][j]!=0){
                    dp[i][j-nums[i-1]]+=dp[i-1][j];
                    dp[i][j+nums[i-1]]+=dp[i-1][j];
                }
        }
    }
  return dp[n][target+total];
    }

}
