
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] t=new int[tasks.length][3];
        for(int i=0;i<tasks.length;i++){
            t[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }

        Arrays.sort(t,(a,b)->Integer.compare(a[0],b[0]));
     int currentTime =0;

     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           if(a[0]==b[0])return Integer.compare(a[1], b[1]);
           return Integer.compare(a[0], b[0]);
     });

     int i=0;
     int[] ans = new int[tasks.length];
     int j=0;
     
      do{
           if(i<t.length && currentTime<t[i][0])
            currentTime=t[i][0];

        while(i<t.length && currentTime>=t[i][0]){
            pq.offer(new int[]{t[i][1],t[i][2]});i++;
        }
        int cur[]=pq.poll();
        ans[j++]=cur[1];
        currentTime+=cur[0];

      }while(!pq.isEmpty()|| i<t.length);

return ans;
    }
} 