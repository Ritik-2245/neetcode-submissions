class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] m= new int[n+1][2];

        for(int i=0;i<=n;i++){
            m[i][0]=0;
            m[i][1]=0;
        }
         
         int s=trust.length;

         for(int i=0;i<s;i++){
            int a = trust[i][0];
            int b = trust[i][1];

            m[a][1]++;
            m[b][0]++;
         }

         for(int i=1;i<=n;i++){
            if(m[i][0]==n-1 && m[i][1]==0)return i; 
         }
return -1;
    }

}