class Solution {
       public int orangesRotting(int[][] grid) {
       
     int ans =0;
     int n=grid.length;
     int m = grid[0].length;

     Deque<List<Integer>> d = new LinkedList<>();
     int[][] dis = new int[n][m];
     
     for(int i=0;i<n;i++)
        for(int j=0;j<m;j++){
               dis[i][j] = (int)1e7;
               if(grid[i][j]==2)
               {
                d.offer(List.of(i,j));
                dis[i][j] =0;
               }
        }

        int[] xMove ={1,-1,0,0};
        int[] yMove={0,0,-1,1};

        while(!d.isEmpty()){
            List<Integer> t=d.poll();

            int x = t.get(0);
            int y = t.get(1);
int dd = dis[x][y];
            for(int i=0;i<4;i++){
                int a=x+xMove[i];
                int b=y+yMove[i];

                if(a<0 || a>=n || b<0 || b>=m)continue;

                if(grid[a][b]==1 && dis[a][b]>dd+1){
                    dis[a][b]=dd+1;
                    d.offer(List.of(a,b));
                }
            }
        }
      
      for(int i=0;i<n;i++)    
     for(int j=0;j<m;j++){
      if(grid[i][j]==1 && dis[i][j]==(int)1e7)return -1;

        if(dis[i][j]==(int)1e7)continue;
        ans = Math.max(dis[i][j], ans);
     }
     return ans;


    }
}
