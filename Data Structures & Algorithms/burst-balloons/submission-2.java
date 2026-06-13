class Solution {
private int gg[],dp[][];

private int getLeft(int i){
    return i>-1 ? gg[i]:1;
}
private int getRight(int i){
    return i!=gg.length ? gg[i]:1;
}
public int maxCoins(int[] nums) {
    gg=nums;
    int n=nums.length;
    dp=new int[n][n];

    // for(int i=0;i<nums.length;i++)
    //     Arrays.fill(dp[i], Integer.MIN_VALUE);
     
     // return getMaxCoin(0, nums.length-1);
        
        for(int g=0;g<n;g++){
            for(int i=0;i+g<n;i++){
            
            int j=i+g;
             int best=Integer.MIN_VALUE;
             int tmp=getLeft(i-1)*getRight(j+1);
            for(int ind=i;ind<=j;ind++){
                 best=Math.max(best,nums[ind]*tmp+(ind>0 ? dp[i][ind-1]:0)+(ind+1<n ?dp[ind+1][j]:0));
            }
              dp[i][j]=best;

            }
        }

return dp[0][n-1];
    }
}
