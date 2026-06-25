class Solution {
public void solve(List<List<Integer>> ans,List<Integer> cur,int ind,int[] nums){
        if(ind==nums.length){
        	ans.add(new ArrayList<>(cur));return;
        }
             
             cur.add(nums[ind]);
             solve(ans,cur,ind+1,nums);
             cur.removeLast();

             while(ind<nums.length-1 && nums[ind]==nums[ind+1]){
             	ind++;
             }

             solve(ans,cur,ind+1,nums);

}


  public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(ans,new ArrayList<>(),0,nums);
        return ans;
    }
	
}
