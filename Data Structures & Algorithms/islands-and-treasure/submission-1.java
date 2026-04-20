class Solution {
     public void islandsAndTreasure(int[][] grid) {
   Queue<int[]> queue = new LinkedList<>();
    int n= grid.length,m=grid[0].length;
     int[][] dist = new int[n][m];
    for(int i=0;i<n;i++)
        for(int j=0;j<m;j++){
              if(grid[i][j]==0){
                queue.offer(new int[]{i,j});
                dist[i][j]=0;
              }else{
                dist[i][j]=Integer.MAX_VALUE;
              }

        }

        int[] dx= {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while (!queue.isEmpty()) {
             int[] cur= queue.poll();

             for(int i=0;i<4;i++){

              int nx = cur[0]+dx[i];
              int ny = cur[1] + dy[i];

              if(nx <0 || ny <0 || nx>= n || ny >=m || grid[nx][ny] == -1)continue;
               
               if(dist[nx][ny]>dist[cur[0]][cur[1]]+1){
                dist[nx][ny] = dist[cur[0]][cur[1]]+1;
                queue.offer(new int[]{nx,ny});
               }

             }

        }

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(grid[i][j]==2147483647)
                    grid[i][j]=dist[i][j];
            }


    }

}
