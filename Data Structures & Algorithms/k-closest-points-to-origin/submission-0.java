
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int x= a[0]*a[0]+a[1]*a[1];
            int y =b[0]*b[0]+b[1]*b[1];
                  return y-x;
                    });

        for(int[] e: points){
            pq.add(e);
            if(pq.size()>k)
                pq.poll();
        }
        int n=pq.size();
       int[][] w= new int[n][2];
       for(int i=0;i<n;i++){
        w[i]=pq.poll();
       }

       return w;

    }
}
