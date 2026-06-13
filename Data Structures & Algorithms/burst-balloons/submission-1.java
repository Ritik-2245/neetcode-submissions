class Solution {
private int gg[],dp[][];

private int getLeft(int i){
    return i>-1 ? gg[i]:1;
}
private int getRight(int i){
    return i!=gg.length ? gg[i]:1;
}
private int getMaxCoin(int i,int j){

if(j<i)return 0;

if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];

int ans=Integer.MIN_VALUE;

int tmp =getLeft(i-1)*getRight(j+1);

for(int ind=i;ind<=j;ind++){
ans=Math.max(ans,tmp*gg[ind]+getMaxCoin(i,ind-1)+getMaxCoin(ind+1,j));   
}

return dp[i][j]=ans;



}

public int maxCoins(int[] nums) {
    gg=nums;

    dp=new int[nums.length][nums.length];

    for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i], Integer.MIN_VALUE);
     
     return getMaxCoin(0, nums.length-1);


    }

}
