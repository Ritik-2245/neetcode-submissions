class Solution {
   private boolean dfs(int p,int cur,List<Integer>[] gr,boolean[] vis){
    vis[cur] = true;

    for(Integer r:gr[cur]){
        if(r==p)continue;
        if(vis[r])return true;
        if(dfs(cur,r,gr,vis))return true;
    }

    return false;
 }

     public boolean validTree(int n, int[][] edges) {
      List<Integer>[] gr = new ArrayList[n];
        boolean[] vis = new boolean[n];

      for(int i=0;i<n;i++){
        gr[i] = new ArrayList<>();
      }
      for(int i=0;i<edges.length;i++){
        int a = edges[i][0];
        int b= edges[i][1];
        gr[a].add(b);
        gr[b].add(a);
      }
    
    if(dfs(-1,0,gr,vis)) return false;

    for(int i=0;i<n;i++)if(!vis[i]) return false;

    return true;



    }

}
