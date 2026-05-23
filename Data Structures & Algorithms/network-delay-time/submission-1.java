class Solution {
     public static class Pair<K,V> {
      
      K key;
      V value;

     public Pair(K key,V value){
             this.key = key;
             this.value = value;

     }
        
     public K getKey(){
        return key;
     }

     public V getValue(){
        return value;
     }

     public static <K,V> Pair<K,V> of(K key,V value){
        return new Pair<K,V>(key, value);
     }

    }


    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];

        int inf = (int)1e9;

       ArrayList<Pair<Integer,Integer>>[] gr = new ArrayList[n];

       for(int i=0;i<n;i++)
       gr[i]= new ArrayList<Pair<Integer,Integer>>();

       for(int i=0;i<times.length;i++){
            int a = times[i][0]-1;
            int b= times[i][1]-1;
            int d = times[i][2];
            gr[a].add(Pair.of(b,d));
       }

       Arrays.fill(dist,inf);
       dist[k-1]=0;

       PriorityQueue<Pair<Integer,Integer>> heap = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
         heap.add(Pair.of(k-1,0));
        
        while(!heap.isEmpty()){
        Pair<Integer,Integer> cur = heap.poll();

        if(cur.getValue()>dist[cur.getKey()])continue;

         for(Pair<Integer,Integer> p:gr[cur.getKey()]){
                int nei = p.getKey();
                int edge = p.getValue();

                if(dist[nei]>dist[cur.getKey()]+edge){
                    
                    dist[nei]= dist[cur.getKey()]+edge;
                    heap.add(Pair.of(nei,dist[nei]));
                }

         }

        }
        int ans = Arrays.stream(dist).max().getAsInt();

        return ans != inf ? ans :-1;

    }
}
