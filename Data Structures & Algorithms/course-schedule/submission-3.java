class Solution { 
    
        public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] gr = new ArrayList[numCourses];
        int[] indegree= new int[numCourses];
        
          for(int i=0;i<numCourses;i++){
            gr[i]= new ArrayList<>();
              indegree[i]=0;
        }

        for(int i=0;i<prerequisites.length;i++){
                 int[] r= prerequisites[i];
                 indegree[r[0]]++;
                 gr[r[1]].add(r[0]);
        }
      
      Queue<Integer> q= new LinkedList<>();

               int ans =0;

               for(int i=0;i<numCourses;i++)
                if(indegree[i]==0)q.offer(i);
        
        while(!q.isEmpty()){
           Integer r = q.poll();
           ans++;

           for(Integer x:gr[r]){
            indegree[x]--;
            if(indegree[x]==0)q.offer(x);
           }
        }

      return ans == numCourses;

    }


}
