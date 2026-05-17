class Solution {
     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)return List.of(0);
      List<List<Integer>> ed = new ArrayList<>();
      int[] indeg= new int[n];
      for(int i=0;i<n;i++){
        ed.add(new ArrayList<>());
        }
    for(int i=0;i<edges.length;i++){
        int a = edges[i][0];
        int b= edges[i][1];
        ed.get(a).add(b);
        ed.get(b).add(a);
        indeg[a]++;
        indeg[b]++;
    }
        
        Deque<Integer> deque = new LinkedList<>();
    

        for(int i=0;i<n;i++)
        if(indeg[i]==1)deque.offer(i);

        while(n>2){
             int sz= deque.size();
             n-=sz;
            
            for(int i=0;i<sz;i++){
                int x= deque.poll();
                for(int r:ed.get(x)){
                    indeg[r]--;
                    if(indeg[r]==1)
                        deque.offer(r);
                }
            }
        } 

      return new ArrayList<>(deque);   
          }
    
    
}