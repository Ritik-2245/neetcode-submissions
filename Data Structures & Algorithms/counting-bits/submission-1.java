class Solution {

    public int[] countBits(int nums) {
       int[] ans = new int[nums+1];

 for(int i=0;i<=nums;i++){
 	ans[i] = ans[i/2] + i%2;
 }
        return ans;
    }
}
