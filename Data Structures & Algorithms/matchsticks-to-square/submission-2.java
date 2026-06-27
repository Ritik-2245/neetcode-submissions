class Solution {
 
  private boolean solve(int side,int[] matchsticks,int[] cur,int c){
       
       if(c==-1)return true;

      for(int i=0;i<4;i++){
        if(cur[i]+matchsticks[c]<=side){
             cur[i]+=matchsticks[c];
             if(solve(side,matchsticks,cur,c-1))return true;
                   cur[i]-=matchsticks[c];
        }
      }
        
    return false;
  }

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4!=0)return false;
        Arrays.sort(matchsticks);
        return solve(sum/4,matchsticks,new int[4],matchsticks.length-1);
    }

}