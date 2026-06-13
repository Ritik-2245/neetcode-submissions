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
     dp= new int[s.length()+1][t.length()+1];
     // for(int i=0;i<s.length();i++)
     //    Arrays.fill(dp[i], Integer.MAX_VALUE);
    
    for(int i=0;i<=s.length();i++){
        dp[i][0]=i;
    }

    for(int i=0;i<=t.length();i++){
        dp[0][i]=i;
    }



    for(int i=1;i<=s.length();i++){

        for(int j=1;j<=t.length();j++){
           int best = Integer.MAX_VALUE;

           if(s.charAt(i-1)==t.charAt(j-1))
            best=Math.min(best,dp[i-1][j-1]);
        //replace
        best = Math.min(best,1+dp[i-1][j-1]);
         // add
        best = Math.min(best,1+dp[i-1][j]);
        //remove
        best = Math.min(best,1+dp[i][j-1]);

        dp[i][j]=best;
        }
    }
       
return dp[s.length()][t.length()];
        // return getMinEdit(0,0);
    }
}
