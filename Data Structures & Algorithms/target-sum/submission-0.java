class Solution {
public int getComb(int sum,int ind,int target,int[] nums){
    if(ind==nums.length)return (sum==target ? 1:0);
    int ans =0;

    ans+= getComb(sum-nums[ind], ind+1, target, nums);
    ans+=getComb(sum+nums[ind], ind+1, target, nums);
    return ans;
}

 public int findTargetSumWays(int[] nums, int target) {
     
  return getComb(0, 0, target, nums);

    }

}
