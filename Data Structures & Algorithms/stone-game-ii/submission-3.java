class Solution {
public int stoneGameII(int[] piles) {

    int sum = Arrays.stream(piles).sum();
    int n=piles.length;
    // ar=piles;
   int[][]  dp = new int[n+1][n+1];
  // for(int i=0;i<piles.length;i++)
    // Arrays.fill(dp[i], Integer.MIN_VALUE);
    // int s = getmax(0, 1);

    // int score = (sum+s)>>1;
        


    for(int i=n-1;i>=0;i--){

      for(int M= n;M>=1;M--){
          
          int best =Integer.MIN_VALUE;
           int tmp=0;
          for(int X=1;X<=2*M && X+i-1<n;X++){
              tmp+=piles[i+X-1];   
            best = Math.max(best,tmp-dp[i+X][Math.max(M,X)]);
          }
       dp[i][M]=best;
      }


    }

       return (sum+dp[0][1])>>1;
    }




}