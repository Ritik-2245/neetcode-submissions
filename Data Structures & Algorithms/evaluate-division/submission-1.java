class Solution {
      
     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
       Map<String,Integer> index = new HashMap<>();

       int r=0;

       for(List<String> f:equations){
        for(String s:f){
            if(index.containsKey(s))continue;
            index.put(s,r++);
        }
       }

       int n = index.size();
       double[][] dis = new double[n][n];
         
         for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(i!=j)
                dis[i][j] = -1;
                 else
                    dis[i][j]=1;
            for(int i=0;i<equations.size();i++){
                   String a = equations.get(i).get(0);
                   String b = equations.get(i).get(1);
                   double val = values[i];
                   int ai = index.get(a);
                   int bi = index.get(b);
                   dis[ai][bi]=val;
                   dis[bi][ai]=1/val;
            }

            for(int k=0;k<n;k++)
                for(int i=0;i<n;i++)
                    for(int j=0;j<n;j++){
                        if(dis[i][k]!=-1 && dis[k][j]!=-1 && dis[i][j]==-1){
                            dis[i][j] = dis[i][k]*dis[k][j];
                            
                        }
                    }

        double[] ans= new double[queries.size()];
        int u=0;

         for(List<String> l:queries){
            String a = l.get(0);
            String b = l.get(1);

            if(index.containsKey(a) && index.containsKey(b)){
                int ai = index.get(a);
                int bi= index.get(b);
                ans[u++]=dis[ai][bi];
            }else{
                ans[u++]=-1;
            }
         }

        return ans;}
}