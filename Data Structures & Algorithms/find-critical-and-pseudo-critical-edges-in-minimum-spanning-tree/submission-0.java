class Solution {
private static class DSU{

private int par[],sz[];

DSU(int n){
par=new int[n];
sz=new int[n];
Arrays.fill(sz,1);
for(int i=0;i<n;i++)par[i]=i;
}

int getParent(int n){
     return n==par[n] ? n : (par[n]=getParent(par[n]));
}

boolean isDisJoint(int a,int b)
{
    return getParent(a)!=getParent(b);
}

void union(int a,int b){
    int parA = getParent(a);
    int parB=getParent(b);

    if(parA==parB)return;
   
   if(sz[parA]>sz[parB]){
    par[parB]=parA;
    sz[parA]+=sz[parB];
   }else{
    par[parA]=parB;
    sz[parB]+=sz[parA];
   }
}

boolean isCompleteUnion(){
    int god = getParent(0);

    for(int i =0;i<par.length;i++){
        if(god!=getParent(i))return false;
    }
    return true;
}

}

private int getMST(List<List<Integer>> ed,int n,List<Integer> force,List<Integer> ignore){
   DSU dd = new DSU(n);

   int mst =0;

   if(force!=null){
    int w=force.get(0);
    int a=force.get(1);
    int b=force.get(2);
    dd.union(a,b);
    mst+=w;
   }

   for(List<Integer> r:ed){
     if(r.equals(force) || r.equals(ignore))continue;
        int w = r.get(0);
        int a = r.get(1);
        int b= r.get(2);

        if(dd.isDisJoint(a,b)){
            dd.union(a, b);
            mst+=w;
        } 
   }

   if(!dd.isCompleteUnion())return -1;

   return mst;

}


 public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
  List<List<Integer>> ed = new ArrayList<>();
    
    for(int i=0;i<edges.length;i++){
        int w=edges[i][2];
        int a=edges[i][0];
        int b=edges[i][1];
        ed.add(List.of(w,a,b,i));
    }

    ed.sort((a,b)->a.get(0)-b.get(0));
    
    int possibleMst = getMST(ed, n, null,null);

    int[] forcemst=new int[edges.length];
    int[] ignoreMst = new int[edges.length];
          
          for(int i=0;i<edges.length;i++){
        int w=edges[i][2];
        int a=edges[i][0];
        int b=edges[i][1];
        forcemst[i]=getMST(ed, n, List.of(w,a,b,i),null);
    }


          for(int i=0;i<edges.length;i++){
        int w=edges[i][2];
        int a=edges[i][0];
        int b=edges[i][1];
        ignoreMst[i]=getMST(ed, n, null,List.of(w,a,b,i));        
    }

List<Integer> critical= new ArrayList<Integer>();
List<Integer> pseudo = new ArrayList<Integer>();

    for(int i=0;i<edges.length;i++){
              
              if(ignoreMst[i]>possibleMst ||ignoreMst[i]==-1)critical.add(i);
              if(ignoreMst[i]==possibleMst && forcemst[i]==possibleMst)pseudo.add(i);

    }
        
        return List.of(critical,pseudo);
    }

}