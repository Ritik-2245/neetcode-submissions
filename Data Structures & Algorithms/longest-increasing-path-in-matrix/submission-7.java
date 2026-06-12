class Solution {
private int n,m,xMove[],yMove[],dp[][];

private boolean isValidPoint(int a,int b){
    return a>=0 && a<n && b>=0 && b<m;
}

private int getMaxPath(int a,int b,int[][] mat){


    if(dp[a][b]!=-1) return dp[a][b];

    int ans = 0;

    for(int i=0;i<4;i++){
      int x=a+xMove[i];
      int y=b+yMove[i];

      if(!isValidPoint(x, y) || mat[a][b]<=mat[x][y])continue;

     ans = Math.max(ans, 1+getMaxPath(x, y, mat));
    }

return (dp[a][b]=ans);
}


public int longestIncreasingPath(int[][] matrix) {
     
n=matrix.length;
m=matrix[0].length;
dp=new int[n][m];
xMove = new int[]{0,0,-1,1};
yMove = new int[]{1,-1,0,0};

int ans=0;
for(int g=0;g<n;g++)Arrays.fill(dp[g], -1);
for(int i=0;i<n;i++){
   for(int j=0;j<m;j++){
    ans=Math.max(ans,1+getMaxPath(i,j,matrix));}
}

return ans;

    }

}