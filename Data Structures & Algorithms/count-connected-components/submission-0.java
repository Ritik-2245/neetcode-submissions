class Solution {

   private void dfs(int node,List<Integer>[] gr,boolean[] vis){
    vis[node]=true;
    for(Integer r:gr[node]){
        if(!vis[r])
        dfs(r,gr,vis);
    }
   }

    public int countComponents(int n, int[][] edges) {
      boolean[] vis = new boolean[n];
      List<Integer>[] gr = new ArrayList[n];

      for(int i=0;i<n;i++){
        gr[i]= new ArrayList<>();
      }
      
      for(int i=0;i<edges.length;i++){
        int a = edges[i][0];
        int b= edges[i][1];
        gr[a].add(b);
        gr[b].add(a);
      }

      int ans=0;
  
  for(int i=0;i<n;i++)
 {
    if(!vis[i]){
        dfs(i,gr,vis);
        ans++;
    }
 }

  return ans;

    }
}
