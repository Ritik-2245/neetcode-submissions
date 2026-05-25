class Solution {
    private List<String> ans= new ArrayList<>();
 private Map<String,PriorityQueue<String>> gr = new HashMap<>();


private void dfs(String node){
  
  PriorityQueue<String> neig = gr.get(node);
  while(neig!=null && !neig.isEmpty())
    dfs(neig.poll());


ans.add(node);
}

public List<String> findItinerary(List<List<String>> tickets) {
      for(List<String> pl:tickets){
                String a = pl.getFirst();
                String b= pl.getLast();
            

                if(!gr.containsKey(a))
                    gr.put(a,new PriorityQueue<String>());
                gr.get(a).add(b);
      }

     dfs("JFK");

    
     return ans.reversed();   
    }
}
