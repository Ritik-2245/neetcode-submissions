class Solution {
    private int n,m;

private boolean isValid(int x,int y){
        return x > -1 && x<n && y>-1 && y<m;
}

private int[] xMove= {0,0,1,-1};
private int[] yMove = {1,-1,0,0};

     public int swimInWater(int[][] grid) {
       n=grid.length;
       m = grid[0].length;
      int inf = (int)1e9;
       int[][] time = new int[n][m];
       // Arrays.fill(time,inf);
          for(int i=0;i<n;i++)
            Arrays.fill(time[i],inf);
         time[0][0]=grid[0][0];
         PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{grid[0][0],0,0});
           
           while(!q.isEmpty()){
            int[] cur = q.poll();
            int x=cur[1];
            int y=cur[2];
            int d= cur[0];
             if(d>time[x][y])continue;

             for(int i=0;i<4;i++){
                int xN = x+xMove[i];
                int yN = y+yMove[i];

                if(!isValid(xN,yN))continue;

                if(d>=grid[xN][yN] && d<time[xN][yN]){
                   time[xN][yN]=d;
                   q.add(new int[]{d,xN,yN});
                }

               else if(d<grid[xN][yN] && grid[xN][yN]<time[xN][yN]){
                    time[xN][yN]=grid[xN][yN];
                   q.add(new int[]{grid[xN][yN],xN,yN});
                }
             }

           }


        return time[n-1][n-1];
    }

}
