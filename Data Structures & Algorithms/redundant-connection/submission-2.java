class Solution {


    private int[] par,size;

    private int getParent(int node){
        return node!=par[node]?par[node]=getParent(par[node]) : node;
    }

    private void union(int a,int b){
        int aPar = getParent(a);
        int bPar = getParent(b);

        if(aPar!=bPar){
             
             if(size[aPar]>size[bPar]){
                par[bPar]=aPar;
                size[aPar]+=size[bPar];
             }else{
                par[aPar]= bPar;
                size[bPar]+=size[aPar];
             }

        }
    }

 private boolean isSameSet(int a,int b){
    return getParent(a) == getParent(b);
 }



    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par= new int[n+1];
        size = new int[n+1];
        
        for(int i=0;i<=n;i++){
            par[i]=i;
            size[i]=1;
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
        
            int b = edges[i][1];
            
              if(isSameSet(a,b))
              return edges[i];

              union(a,b);

        }

        return new int[0];
    }
}
