class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
        int ans =Integer.MAX_VALUE;

        if(i>0)
        ans = Math.min(ans,grid[i-1][j]+grid[i][j]);

        if(j>0)
        ans = Math.min(ans,grid[i][j-1]+grid[i][j]);

        if(ans != Integer.MAX_VALUE)
        grid[i][j]=ans; 

    }
}
return grid[m-1][n-1];
    }
}