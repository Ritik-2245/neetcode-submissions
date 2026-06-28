class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
           
          PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
            
for(int[] e: trips){
          pq.offer(new int[]{e[1],e[0]});
          pq.offer(new int[]{e[2],-e[0]});
}

int curCap=0;



while(!pq.isEmpty()){
   int rr = pq.peek()[0];
   while(!pq.isEmpty()&& rr==pq.peek()[0]){
    curCap+=pq.poll()[1];
   }
   if(curCap>capacity)return false;

}

return true;

    }

}