class Solution {
  public int maxProduct(int[] nums) {
    
    int last1=1,last2=1,ans=Integer.MIN_VALUE,cur=1;
    boolean flag=false;
   
   for(int c:nums){
       
       if(flag){
        last1*=c;
       }

     

     last2*=c;

     

     if(flag){
        ans=Math.max(ans,last1);
     }
     ans=Math.max(ans,last2);


     if(c==0)
     {
        last1=1;
        flag=false;
        last2=1;
        continue;
     }
     if(c<0){
        flag=true;
     }

   }

return ans;


    }
}
