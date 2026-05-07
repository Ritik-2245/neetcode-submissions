class Solution {
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
      
     boolean[][] reach = new boolean[numCourses][numCourses];

     for(int i=0;i<prerequisites.length;i++){
        int a = prerequisites[i][0];
        int b= prerequisites[i][1];

        reach[a][b]=true;
     }

     for(int i=0;i<numCourses;i++)
        for(int j=0;j<numCourses;j++)
            for(int k=0;k<numCourses;k++)
                if(reach[i][k] && reach[k][j]){
                    reach[i][j]=true;
                    break;
                }

List<Boolean> ans = new ArrayList<>();

for(int i=0;i<queries.length;i++){
    int a = queries[i][0];
    int b=queries[i][1];
    ans.add(reach[a][b]);
}

return ans;

    }

}