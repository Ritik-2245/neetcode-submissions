class Solution {
  public String longestDiverseString(int a, int b, int c) {
               PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->Integer.compare(y[0], x[0]));
              if(a!=0)
                pq.offer(new int[]{a,0});
                if(b!=0)
                pq.offer(new int[]{b,1});
                if(c!=0)
                pq.offer(new int[]{c,2});
              char[] m = new char[]{'a','b','c'};
            StringBuilder sb = new StringBuilder();
        

            while(!pq.isEmpty()){
                int[] cur = pq.poll();
            
                
                if(sb.length()>1 && sb.charAt(sb.length()-1)==sb.charAt(sb.length()-2) && sb.charAt(sb.length()-1)==m[cur[1]]){
                    if(pq.isEmpty())break;

                    int[] w = pq.poll();
            
                    w[0]--;
                    sb.append(m[w[1]]);
                    if(w[0]>0)pq.offer(w);
                }
                
                cur[0]--;
                sb.append(m[cur[1]]);
                if(cur[0]>0)pq.offer(cur);
    

            }
            return sb.toString();
    }
}