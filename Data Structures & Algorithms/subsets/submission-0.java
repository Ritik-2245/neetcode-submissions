class Solution {
    private void solve(List<List<Integer>> ans,List<Integer> cur,int[] nums,int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        solve(ans,cur,nums,++i);
        cur.removeLast();
        solve(ans,cur,nums,i);
    } 
   
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

     solve(ans,new ArrayList<>(),nums,0);
        return ans;
    }
}
