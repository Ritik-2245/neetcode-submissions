class Solution {


private void dfs(int n,int m,int x,int y,char[][] grid){
   if(grid[x][y]=='0')return;
      grid[x][y] = '0';
  
         if(x+1<n)
        dfs(n,m,x+1,y,grid);

         if(x-1>-1)
        dfs(n,m,x-1,y,grid);

        if(y+1<m)
        dfs(n,m,x,y+1,grid);

         if(y-1>-1)
        dfs(n,m,x,y-1,grid);
   
}

  public int numIslands(char[][] grid) {
     int ans =0;
        int n=grid.length,m=grid[0].length;

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(n,m,i,j,grid);
                }
            }

  return ans;
    }

}
