class Solution {
private String x,y,z;
private int[][] dp;

private boolean checkInterLeaving(int a,int b)
{
  if(a==x.length() && b==y.length())return true;

if(dp[a][b]!=0) return (dp[a][b]==1 ? true :false);

boolean ans = false;

if(a<x.length() && x.charAt(a)==z.charAt(a+b))
    ans|=checkInterLeaving(a+1, b);

if(b<y.length() && y.charAt(b)==z.charAt(a+b))
    ans|=checkInterLeaving(a, b+1);
dp[a][b]=(ans ? 1:-1);
return ans;
}
 public boolean isInterleave(String s1, String s2, String s3) {
    
    if(s1.length()+s2.length()!=s3.length())return false;
     dp = new int[s1.length()+1][s2.length()+1];
     x=s1;
     y=s2;
    z=s3;

return checkInterLeaving(0, 0);

    }

}
