class Solution {
    public int rob(int[] nums) {
 int n = nums.length;

 if(n==1)return nums[0];

        int[] cp = Arrays.copyOf(nums,nums.length);

        // 0 is considered.
        cp[1]=cp[0];

        for(int i=2;i<n-1;i++){
            cp[i]=Math.max(cp[i-2]+cp[i],cp[i-1]);
        }
       // 0 is not considered.
       nums[0]=0;

       for(int i=2;i<n;i++)
       nums[i]=Math.max(nums[i-2]+nums[i],nums[i-1]);

       return Math.max(cp[n-2],nums[n-1]);
        
    }
}
