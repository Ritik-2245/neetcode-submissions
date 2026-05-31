class Solution {
public boolean wordBreak(String s, List<String> wordDict) {
     
     int n=s.length();

     boolean[] dp = new boolean[n+1];
     dp[0]=true;

     for(int i=1;i<=n;i++){
       for(String p:wordDict){
           int rlen=p.length();
           if(rlen>i)
            continue;
           if(!dp[i-rlen])continue;
           dp[i]=s.regionMatches(i-rlen, p, 0, rlen);
           if(dp[i])break;
       }  

     }


     return dp[n];   
    }

}
