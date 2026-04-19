class Solution {
    private boolean checkx(int n,int x,int y,int[][] grid){
        if (x<0 || x>=n)
            return true;

        return grid[x][y] == 0;
    }

    private boolean checky(int m,int x,int y,int[][] grid){
        if(y<0 || y>=m)return true;

        return grid[x][y] == 0;
    }

    private int dfs(int n,int m,int x,int y,int[][] grid){
               
               if(x<0 || y<0 || x>=n || y>=m || grid[x][y]!=1)
                return 0;
                          
            int ans =0;
             grid[x][y] = 2;
        if(checkx(n,x-1,y,grid)) ans++;
        if(checkx(n,x+1,y,grid))ans++;
      if(checky(m,x,y-1,grid))ans++;
        if(checky(m,x,y+1,grid))ans++; 

        ans += dfs(n,m,x-1,y,grid);
        ans += dfs(n,m,x+1,y,grid);
        ans += dfs(n,m,x,y-1,grid);
        ans+= dfs(n,m,x,y+1,grid);

        return ans;


    }


 public int islandPerimeter(int[][] grid) {
        int n= grid.length,m=grid[0].length;
           
           int ans=0;
             
             for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    if(grid[i][j] == 1)
                        ans+= dfs(n,m,i,j,grid);
             }
return ans;
    }

}