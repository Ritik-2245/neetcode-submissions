class Solution {
private boolean recur(int ind,int total,int target,int[] nums,int[][] dp){
    if(ind==nums.length)return false;
    if(total==target)return true;

    if(total>target)return false;

    if(dp[ind][total]!=-1)return (dp[ind][total]==1);

    boolean flag= recur(ind+1,total,target,nums,dp) ;
    
    if(flag){
dp[ind][total]=1;
return true;
    }

     flag = recur(ind+1,total+nums[ind],target,nums,dp);

    dp[ind][total]=(flag == true ? 1:0);

    return flag;
}


  public boolean canPartition(int[] nums) {
        int target = Arrays.stream(nums).sum();
        if(target%2==1)return false;
        int n=nums.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);

        return recur(0,0,target/2,nums,dp);
    }

}
