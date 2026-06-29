class Solution {
public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
              
              int[][] task = new int[profits.length][2];

              for(int i=0;i<profits.length;i++){
                task[i]= new int[]{capital[i],profits[i]};
              } 

              Arrays.sort(task,(a,b)->Integer.compare(a[0], b[0]));

              PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1], a[1]));       
           int i=0;
            while(i<task.length && w>=task[i][0]){
                pq.offer(task[i]);i++;
            }

            while(!pq.isEmpty() && k>0){
                w+=pq.poll()[1];
                k--;

                while(i<task.length && w>=task[i][0]){
                pq.offer(task[i]);i++;
            }
            }
            return w;
               



    }
}