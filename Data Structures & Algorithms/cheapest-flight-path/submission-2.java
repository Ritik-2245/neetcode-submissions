class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     int[] dist  = new int[n];
     int inf = (int)1e9;
     Arrays.fill(dist, inf);
     dist[src]=0;
     for(int i=0;i<=k;i++){
        int[] temp=Arrays.copyOf(dist, n);
        for(int[] r:flights){
            int a=r[0];
            int b=r[1];
            int p=r[2];

            if(dist[a]!=inf && temp[b]>dist[a]+p){
                temp[b]=dist[a]+p;
            }
        }
        dist=temp;
     }
     return dist[dst]!=inf ? dist[dst] : -1;
    }


}
