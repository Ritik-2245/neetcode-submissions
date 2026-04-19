class Solution {

  private int solve(int i){
    int ans=0;
    while(i>0){
   if((i&1)==1)ans++;

   i>>=1;


    }
    return ans;
  }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++)
        ans[i]=solve(i);

        return ans;
    }
}
