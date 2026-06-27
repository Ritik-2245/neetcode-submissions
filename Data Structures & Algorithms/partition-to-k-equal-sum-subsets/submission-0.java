class Solution {
 public boolean solve(int k,int s,int[] nums,int cur,int[] part){
      if(cur==-1)return true;
    
           for(int i=0;i<k;i++){
            if(part[i]+nums[cur]<=s){
                part[i]+=nums[cur];
                if(solve(k,s,nums,cur-1,part))return true;
                part[i]-=nums[cur];
            }
           }
return false;
      }


     public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k!=0)return false;
        Arrays.sort(nums);
          return solve(k,sum/k,nums,nums.length-1,new int[k]);

    }
}