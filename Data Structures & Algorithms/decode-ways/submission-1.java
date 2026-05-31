class Solution {
 public int numDecodings(String s) {
      if(s.charAt(0)=='0')return 0;
      int n=s.length();
      int[] dp = new int[n+1];
      dp[0]=1;
      dp[1]=1;
       for(int i=2;i<=n;i++){
                
            int onedi = Integer.parseInt(s.substring(i-1,i));
            int twoDig = Integer.parseInt(s.substring(i-2,i));

            if(onedi>=1)dp[i]+=dp[i-1];
            if(twoDig>=10 && twoDig<=26)dp[i]+=dp[i-2];

       }
return dp[n];
    }


}
