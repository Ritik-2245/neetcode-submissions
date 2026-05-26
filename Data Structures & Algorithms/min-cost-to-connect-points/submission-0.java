class Solution {
    private int par[],sz[];

    private int getParent(int r){

        return r== par[r] ? r : (par[r]=getParent(par[r]));
    }

    private void unionSet(int a,int b){
        int parA= getParent(a);
        int parB = getParent(b);

        if(sz[parA]>sz[parB]){
            par[parB]=parA;
            sz[parA]+=sz[parB];
        }else{
            par[parA]=parB;
            sz[parB]+=sz[parA];
        }
    }

    private boolean isDisjoint(int a,int b){
        return getParent(a) != getParent(b);
    }

     public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int ans=0;
        par=new int[n];
        sz=new int[n];

        for(int i=0;i<n;i++){
            par[i]=i;
            sz[i]=1;
        }
        
        List<List<Integer>> pp = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int d = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pp.add(List.of(d,i,j));
            }
        }

        pp.sort((a,b)->a.get(0)-b.get(0));
        
          for(List<Integer> k:pp){
            int a = k.get(1);
            int b = k.get(2);
            int d = k.get(0);
            if(isDisjoint(a,b)){
                ans +=d;
                unionSet(a, b);
            }
          }

        return ans;  

    }

}
