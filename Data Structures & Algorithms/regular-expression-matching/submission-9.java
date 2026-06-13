class Solution {
  public boolean isMatch(String s, String p) {
        // a=s;
        // b=p;
     boolean[][] dp=new boolean[s.length()+1][p.length()+1];

 // dp[0][0]=true;

for(int i=0;i<=s.length();i++){

    for(int j=0;j<=p.length();j++){

    if(i==0 && j==0){
        dp[i][j]=true;
    }else if(i==0){
     char c = p.charAt(j-1);

     if(c=='*'){
        dp[i][j]=dp[i][j-2];
     }
    
    }else if(j==0){
        dp[i][j]=false;

    }else{
   char chS= s.charAt(i-1);
   char chP=p.charAt(j-1);

   if(chP=='*'){
     
     dp[i][j]=dp[i][j-2];

     if(chS==p.charAt(j-2) || p.charAt(j-2)=='.'){
        dp[i][j]|=dp[i-1][j];
     }

   }else if(chS==chP || chP=='.'){
         dp[i][j]=dp[i-1][j-1];
   }else{
    dp[i][j]=false;
   }



    }



    }

}
 return dp[s.length()][p.length()];
}

}
