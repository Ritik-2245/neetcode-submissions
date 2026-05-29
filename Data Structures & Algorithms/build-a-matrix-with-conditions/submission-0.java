class Solution {
private List<Integer> getTopoList(int[][] conditions,int n){
     
     List<Integer>[] gr = new ArrayList[n+1];
     for(int i=1;i<=n;i++)
        gr[i]= new ArrayList<Integer>();
     List<Integer> ans = new ArrayList<>();
     int[] indegree = new int[n+1];
      for(int[] r:conditions){
        int a = r[0];
        int b= r[1];
        indegree[b]++;
        gr[a].add(b);
      }

      Queue<Integer> q = new LinkedList<Integer>();

      for(int i=1;i<=n;i++)
        if(indegree[i]==0)q.offer(i);

    while(!q.isEmpty()){
        int cur = q.poll();
        ans.add(cur);

        for(Integer nei:gr[cur]){
            indegree[nei]--;
            if(indegree[nei]==0)q.offer(nei);
        }
    }



return ans.size()==n ? ans : new ArrayList<>();
}


public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
     
    List<Integer> rows = getTopoList(rowConditions, k);

    if(rows.size()==0)
     return new int[0][0];

      List<Integer> cols = getTopoList(colConditions, k);

    if(cols.size()==0)
     return new int[0][0];   

 int[][] ans = new int[k][k];

 int[][] cord=new int[k][2];

 for(int i=0;i<k;i++){
    int e=rows.get(i);
    cord[e-1][0]=i;
 }

 for(int i=0;i<k;i++){
    int e=cols.get(i);
    cord[e-1][1]=i;
 }


 for(int i=0;i<k;i++){
    int x=cord[i][0];
    int y=cord[i][1];
    ans[x][y]=i+1;
 }

 return ans;

    }

}