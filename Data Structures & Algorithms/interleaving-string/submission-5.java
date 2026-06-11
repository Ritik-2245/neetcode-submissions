class Solution {
 public boolean isInterleave(String s1, String s2, String s3) {
    
    if(s1.length()+s2.length()!=s3.length())return false;
     // dp = new int[s1.length()+1][s2.length()+1];
    
    int a=s1.length(),b=s2.length();
    boolean[][] dp = new boolean[a+1][b+1];
    dp[a][b]=true;
      

      for(int i=a;i>=0;i--){
        for(int j=b;j>=0;j--)
      {
        if(i==a && j==b)continue;
        boolean ans = false;

        if(i<a && s1.charAt(i)==s3.charAt(j+i))
            ans|=dp[i+1][j];
        if(j<b && s2.charAt(j)==s3.charAt(j+i))
            ans|=dp[i][j+1];

        dp[i][j]=ans;
      }
  }

return dp[0][0];

// return checkInterLeaving(0, 0);

    }
}
