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

private List<Integer> primes = new ArrayList<>();
private int inf = (int)1e5+10;
private boolean[] seives = new boolean[inf];

private void calSieve(){

   
   for(int i=2;i<inf;i++){
    if(seives[i])continue;
      for(int j=i*2;j<inf;j+=i){
        seives[j]=true;
      }
   }

   for(int i=2;i<inf;i++){
    if(!seives[i])primes.add(i);
   }

}




public boolean canTraverseAllPairs(int[] nums) {
        calSieve();
   int[] indices = new int[primes.size()];
   Arrays.fill(indices,-1);
   DSU dd = new DSU(nums.length);

   for(int i=0;i<nums.length;i++){
     
     int e= nums[i];

    for(int j=0;j<primes.size();j++){
        int pr = primes.get(j);

        if(e%pr==0){
          if(indices[j]!=-1){
            dd.union(indices[j],i);
           
          }else{
            indices[j]=i;
          }
      while(e%pr==0)
           e/=pr;
                  }
    }    
    
}

return dd.isCompleteUnion();

    }
}