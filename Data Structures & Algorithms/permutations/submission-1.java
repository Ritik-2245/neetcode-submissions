class Solution {

    public boolean next_Permutation(int[] nums){
	int j=nums.length-2;

	// finding break-point

	while(j>-1 && nums[j]>=nums[j+1]){
		j--;
	}

	if(j==-1)return false;
    //finding its replacement

    int y=nums.length-1;
         
         while(y>-1 && nums[j]>=nums[y]){
            y--;
         }
        //swap
         int tmp =nums[j];
         nums[j]=nums[y];
         nums[y]=tmp; 
       
       for(int ind=1;ind<=(nums.length-j)/2;ind++){
       	int a=j+ind;
       	int b=nums.length-ind;

       	int t=nums[a];
       	nums[a]=nums[b];
       	nums[b]=t;
       }

       return true;
}
	

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
         Arrays.sort(nums);
       do{
       ans.add(Arrays.stream(nums).boxed().toList());
       }while(next_Permutation(nums));
return ans;
    }
}
