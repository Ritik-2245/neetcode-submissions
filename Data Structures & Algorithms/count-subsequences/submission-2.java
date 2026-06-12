class Solution {
private String a,b;
private int[][] dp;

private int getPossibleWays(int i,int j){
  if(i==a.length() && j!=b.length())return 0;
  int ans=0;
  if(j==b.length())return 1;
  if(dp[i][j]!=-1)return dp[i][j];
  if(a.charAt(i)==b.charAt(j))
    ans+=getPossibleWays(i+1,j+1);
 ans+=getPossibleWays(i+1, j);
return (dp[i][j]=ans);
}

 public int numDistinct(String s, String t) {
     a=s;
     b=t;
    dp= new int[s.length()+1][t.length()+1];
    // for(int i=0;i<s.length();i++)Arrays.fill(dp[i], -1);
    //  return getPossibleWays(0, 0);   
    for(int i=0;i<=s.length();i++)dp[i][t.length()]=1;
    for(int i=s.length()-1;i>=0;i--){
        for(int j=t.length()-1;j>=0;j--){
          int ways=0;

          if(s.charAt(i)==t.charAt(j))
            ways+=dp[i+1][j+1];

        ways+=dp[i+1][j];

        dp[i][j]=ways;
        }
    }
     return dp[0][0];

    }

}
