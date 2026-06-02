class Solution {
public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if(target%2==1)return false;
        int n=nums.length;
        int total= target/2;
        boolean[][] dp = new boolean[n+1][total+1];

        // for(int i=0;i<=n;i++)dp[i][0]=true;
        dp[0][0]=true;
             for(int i=1;i<=n;i++){
                dp[i][0]=true;
                for(int j=1;j<=total;j++){
                

                    dp[i][j]=dp[i-1][j] ;
                    
                    if(j>=nums[i-1])
                    dp[i][j]|=dp[i-1][j-nums[i-1]];
                }}
                return dp[n][total];

    }
}
