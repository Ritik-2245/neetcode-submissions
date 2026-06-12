class Solution {
private String s,t;
private int[][] dp;

public int getMinEdit(int i,int j){
     
     if(i==s.length()){
        return t.length()-j;
     }

     if(j==t.length()){
        return s.length()-i;
     }

     if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];

     int ans=Integer.MAX_VALUE;

     if(s.charAt(i)==t.charAt(j))
        ans=getMinEdit(i+1,j+1);
     //remove
    ans= Math.min(ans,1+getMinEdit(i+1,j));
    //add
    ans=Math.min(ans,1+getMinEdit(i,j+1));
    ans=Math.min(ans,1+getMinEdit(i+1,j+1));
return (dp[i][j]=ans);
}


  public int minDistance(String word1, String word2) {
     s=word1;
     t=word2;
     dp= new int[s.length()][t.length()];
     for(int i=0;i<s.length();i++)
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        return getMinEdit(0,0);
    }
}
