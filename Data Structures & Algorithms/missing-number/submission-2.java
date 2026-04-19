class Solution {
    public int missingNumber(int[] nums) {

        int ans=nums.length;
        int n =ans;
        for(int i=0;i<n;i++){
            ans ^= i^nums[i];
        }
        return ans;
    }
}
