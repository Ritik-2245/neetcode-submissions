class Solution {
public int getMaxProduct(int n,int k,int[] dp){
if(n==1)return 1;

int ans=(n==k?1:n);

if(dp[n]!=0)return dp[n];

for(int i=1;i<n;i++){
        int pr = getMaxProduct(i,k,dp)*getMaxProduct(n-i,k,dp);
        ans = Math.max(ans,pr);
}

return (dp[n]=ans);
}


 public int integerBreak(int n) {
        int[] dp = new int[n+1];
        return getMaxProduct(n,n,dp);

    }


}