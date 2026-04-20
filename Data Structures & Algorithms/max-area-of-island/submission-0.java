class Solution {


 int[] move = {1,-1};

private boolean checkMove(int val,int f){
    return f > -1 && f<val;
}

private int dfs(int n,int m,int x,int y,int[][] grid){
   if(grid[x][y]==0)return 0;
      grid[x][y] = 0;
      int ans =1;
   for(int p:move){
     
     if(checkMove(n,x+p))
        ans+=dfs(n,m,x+p,y,grid);
        

    if(checkMove(m,y+p))
       ans+= dfs(n,m,x,y+p,grid);
   }
   return ans;
}

  public int maxAreaOfIsland(int[][] grid) {
     int ans =0;
        int n=grid.length,m=grid[0].length;

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   
                  ans =Math.max(ans,dfs(n,m,i,j,grid));
                }
            }

  return ans;
    }


}
