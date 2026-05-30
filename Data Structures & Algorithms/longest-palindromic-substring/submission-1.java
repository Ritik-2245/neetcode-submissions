class Solution {
public String longestPalindrome(String s) {
int n = s.length();
  boolean[][] dp = new boolean[n][n];     
    int[] ans = new int[]{0,0};
    int le =1;
     for(int g=0;g<n;g++){
      
      for(int i=0,j=g;j<n;j++,i++){
             
             if(g==0){
                dp[i][j]=true;
             }else if(g==1){
                if(s.charAt(i)==s.charAt(j))dp[i][j]=true;
                else dp[i][j]=false;
             }else{
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
                dp[i][j]=true;
                else dp[i][j]=false;
             }
        
        if(dp[i][j]==true && g+1>le){
            le=g+1;
            ans[0]=i;
            ans[1]=j;
        }
      }
    

     }
         
return s.substring(ans[0],ans[1]+1);

    }
}
