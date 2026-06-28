class Solution {
    public int leastInterval(char[] tasks, int n) {
       int[] fr=new int[26];
       for(char r:tasks)
       fr[r-'A']++;
      
      PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

      for(int i:fr){
        if(i!=0)pq.offer(i);
      }

      int time=0;
      List<Integer> tt=new ArrayList<>();
      while(!pq.isEmpty()){
          int cycle=n+1;
            tt.clear();
          while(cycle>0 && !pq.isEmpty()){
             int cnt=pq.poll();
             cnt--;
             if(cnt!=0)tt.add(cnt);
           cycle--;
           time++;
          }

          for(int kk:tt)
              pq.offer(kk);
              //empty slots in this cycle

        if(!pq.isEmpty())
          time+=cycle;

      }

return time;
    }
}
