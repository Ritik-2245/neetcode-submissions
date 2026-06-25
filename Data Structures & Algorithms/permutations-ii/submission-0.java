class Solution {
   private void solve(List<List<Integer>> ans,List<Integer> cur,int[] nums,boolean[] used){
    
    if(cur.size()==nums.length){
    	ans.add(new ArrayList<>(cur));
    	return;
    }

    for(int i=0;i<nums.length;i++){
    	if(used[i])continue;
        
        if(i>0 && nums[i-1]==nums[i] && !used[i-1])continue;

        cur.add(nums[i]);
        used[i]=true;
        solve(ans,cur,nums,used);
        cur.removeLast();
        used[i]=false;
    }
 
   }




     public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        solve(ans,new ArrayList<>(),nums, new boolean[nums.length]);

        return ans;
    }
	
}