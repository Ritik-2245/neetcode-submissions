class Solution {
       private List<Integer> neigh(String s,Map<String,Integer> ind,Set<Character> r){
        Set<Integer> ans = new HashSet<>();
         StringBuilder builder = new StringBuilder(s);

         for(int i=0;i<s.length();i++){
              char cur = builder.charAt(i);

              for(char w: r){
                builder.setCharAt(i, w);

                if(ind.containsKey(builder.toString())){
                    ans.add(ind.get(builder.toString()));
                }
              }
              builder.setCharAt(i, cur);
         }


        return  new ArrayList<Integer>(ans);
    }

     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Map<String,Integer> ind = new HashMap<>();
      wordList.add(beginWord);
      
      
      
      Set<Character> e = new HashSet<>();
      int y=0;

      for(String t: wordList){
        ind.put(t,y++);
        for(char q:t.toCharArray())
            e.add(q);
      }
      if(!ind.containsKey(endWord)) return 0;

     List<List<Integer>> padosi = new ArrayList<>();
    
    for(String o:wordList){
        padosi.add(neigh(o,ind,e));
    }
     int start = ind.get(beginWord);

     int[] dis = new int[wordList.size()];

     for(int i=0;i<wordList.size();i++)
        dis[i] = 1000000;
dis[start] =1;

Deque<Integer>  deq = new LinkedList<>();
deq.offer(start);

while(!deq.isEmpty()){
  int x = deq.poll();
  int d = dis[x];


  for(Integer nee:padosi.get(x)){
     if(dis[nee]>d+1){
        dis[nee]=d+1;
        deq.offer(nee);
     }

  }

}
int end= ind.get(endWord);


      return dis[end]==1000000 ? 0 : dis[end];   
    }
}
