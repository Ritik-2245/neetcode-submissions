class Solution {
public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if(target%2==1)return false;
        int n=nums.length;
        int total= target/2;
        boolean[] dp = new boolean[total+1];
          boolean[] temp = new boolean[total+1];

        // for(int i=0;i<=n;i++)dp[i][0]=true;
        dp[0]=true;
             for(int i=0;i<n;i++){
               
                temp = new boolean[total+1];
                for(int j=1;j<=total;j++){
                

                    temp[j]=dp[j];
                    
                    if(j>=nums[i])
                    temp[j]|=dp[j-nums[i]];
                }
                dp=temp;
                
                }
                return dp[total];

    }
}
