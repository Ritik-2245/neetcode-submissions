class Solution {
    private int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};

 private boolean checkCell(int x,int y,int n,int m){
      return x>=0 && x <n && y>=0 && y<m;
       } 


    private void dfs(int r,int c,char[][] board,int n,int m){
     board[r][c] ='#';
  for(int i=0;i<4;i++){
        int x=r+moves[i][0];
        int y=c+moves[i][1];
            
            if(checkCell(x,y,n,m) && board[x][y]=='O')
                 dfs(x,y,board,n,m);
      }

    }


  public void solve(char[][] board) {
            int n= board.length;
            int m= board[0].length;
   boolean[][] vis = new boolean[n][m];

   for(int i=0;i<n;i++)
    for(int j=0;j<m;j++)
        vis[i][j]=false;

   for(int i=0;i<n;i++){
    if(board[i][0]=='O')dfs(i,0,board,n,m);
    if(board[i][m-1]=='O')dfs(i,m-1,board,n,m);
   }

    for(int i=0;i<m;i++){
    if(board[0][i]=='O')dfs(0,i,board,n,m);
    if(board[n-1][i]=='O')dfs(n-1,i,board,n,m);
   }
     
     for(int i=0;i<n;i++)
     for(int j=0;j<m;j++){
        if(board[i][j]=='O')board[i][j] ='X';
        if(board[i][j]=='#')board[i][j]='O';
     }

  }



}
