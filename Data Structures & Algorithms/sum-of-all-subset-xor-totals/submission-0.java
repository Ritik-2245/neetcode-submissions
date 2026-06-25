class Solution {
    
    private void solve(int xor,int[] nums,int[] a,int i){
        if(i==nums.length){
            a[0]+=xor;
            return;
        }
        solve(xor^nums[i],nums,a,++i);
        solve(xor,nums,a,i);

    }

    public int subsetXORSum(int[] nums) {
        int[] a=new int[1];
        solve(0,nums,a,0);
        return a[0];
    }
}