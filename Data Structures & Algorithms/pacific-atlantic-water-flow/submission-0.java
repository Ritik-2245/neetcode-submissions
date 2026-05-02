class Solution {
    private int[] xd = {0,0,-1,1};
    private int[] yd  = {1,-1,0,0};

private boolean checkCell(int x,int y,int n,int m){
    return x>=0 && x <n && y>=0 && y<m;
}


private void dfs(int prvH,int row,int col,int[][] heights,int[][] vis){
      int n = heights.length;
  int m = heights[0].length;
  vis[row][col] = 1;

  for(int i=0;i<4;i++){
    int x= row+xd[i];
    int y =col+yd[i];
    if(checkCell(x,y,n,m) && vis[x][y]==0  && heights[row][col]<=heights[x][y])
    dfs(heights[row][col],x,y,heights,vis);
  }
   
}

private void runDfsRow(int row,int[][] heights,int[][] vis){
  int m = heights[0].length;
  for(int i=0;i<m;i++){
     dfs(-1,row,i,heights,vis);

  }
}

private void runDfsCol(int col,int[][] heights,int[][] vis){
  int n = heights.length;
  for(int i=0;i<n;i++){
     dfs(-1,i,col,heights,vis);

  }
}



 public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
  int n = heights.length;
  int m = heights[0].length;
 int[][] vis1 = new int[n][m];
 int[][] vis2 = new int[n][m];

 for(int i=0;i<n;i++)
    for(int j=0;j<m;j++){
        vis1[i][j]=0;
        vis2[i][j]=0;
    }


//vis1
    runDfsRow(0,heights,vis1);
    runDfsCol(0,heights,vis1);

//vis2
     runDfsRow(n-1,heights,vis2);
    runDfsCol(m-1,heights,vis2);

  List<List<Integer>> ans = new ArrayList<>();

  for(int i=0;i<n;i++)
    for(int j=0;j<m;j++)
        if(vis1[i][j]!=0 && vis2[i][j]!=0)
            ans.add(Arrays.asList(i,j));


        return ans;


    }

}
