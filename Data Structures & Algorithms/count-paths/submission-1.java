class Solution {
  public int uniquePaths(int m, int n) {
     int[] grid = new int[n];

    //   grid[0]=1;

    int[]temp = new int[n];


      for(int i=0;i<m;i++){
         grid = new int[n];
         if(i==0)grid[0]=1;
        for(int j=0;j<n;j++)
{
         if(i>0)
            grid[j]+=temp[j];

        if(j>0)
            grid[j]+=grid[j-1];

    }
    temp=grid;

}

    return grid[n-1];
}
}
