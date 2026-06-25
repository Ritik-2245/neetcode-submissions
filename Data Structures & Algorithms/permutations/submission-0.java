class Solution {

   private void solve(List<List<Integer>> ans,List<Integer> cur,int[] nums){
       if(cur.size()==nums.length){
        ans.add(new ArrayList<>(cur));
        return;
       }

       for(int i=0;i<nums.length;i++){
              if(nums[i]<-10)continue;

              int t= nums[i];
              nums[i]=-11;
              cur.add(t);
              solve(ans,cur,nums);
              cur.removeLast();
              nums[i]=t;
       }
   }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans,new ArrayList<>(),nums);
        return ans;
    }
}
