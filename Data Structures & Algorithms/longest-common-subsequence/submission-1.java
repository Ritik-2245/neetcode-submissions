class Solution {
private int recur(int i,int j,String u,String v,int[][] dp){
    if(i>=u.length() || j>=v.length())
        return 0;
    int ans=0;
if(dp[i][j]!=-1)
return dp[i][j];
    
    if(u.charAt(i)==v.charAt(j))
        ans= Math.max(ans,1+recur(i+1,j+1,u,v,dp));

    ans = Math.max(ans,recur(i,j+1,u,v,dp));
    ans = Math.max(ans,recur(i+1,j,u,v,dp));

    return (dp[i][j]=ans);

}

public int longestCommonSubsequence(String text1, String text2) {
    int[][]dp=new int[text1.length()][text2.length()];

    for(int i=0;i<text1.length();i++)
        Arrays.fill(dp[i],-1);
     return recur(0, 0, text1, text2,dp);


    }



}
