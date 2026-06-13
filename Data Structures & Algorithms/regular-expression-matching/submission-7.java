class Solution {
   private String a,b;
  private int dp[][];
 private boolean checkRegrex(int i,int j){
  if(i==a.length()){
     if(j==b.length())return true;

     if(b.charAt(j)=='*')return checkRegrex(i, j+1);
     if(j<b.length()-1 && b.charAt(j+1)=='*') return checkRegrex(i,j+2);
      return false;
  }

  if(j==b.length())return false;
if(dp[i][j]!=0)return dp[i][j]==1;
  boolean ans=false;
  
  if(b.charAt(j)=='.' || a.charAt(i)==b.charAt(j))
    ans|=checkRegrex(i+1,j+1);
  
  if(b.charAt(j)=='*'){
    if(a.charAt(i)==b.charAt(j-1) || b.charAt(j-1)=='.'){
        ans|=checkRegrex(i+1,j);
        ans|=checkRegrex(i+1,j+1);
        }
    ans|=checkRegrex(i, j+1);
  }
  
  if(j<b.length()-1 && b.charAt(j+1)=='*')ans|=checkRegrex(i,j+1);
dp[i][j]=ans?1:-1;
  return ans;

 }

  public boolean isMatch(String s, String p) {
        a=s;
        b=p;
        dp=new int[s.length()][p.length()];

        return checkRegrex(0, 0);
    }
}
