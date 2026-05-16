class Solution {
         private int getParent(int a,int[] par){
                return a == par[a] ? a : (par[a]=getParent(par[a],par));    
  
      } 

      private void unionSet(int a,int b,int[] sz,int[] par){
         int parA=getParent(a,par);
         int parB = getParent(b, par);

         if(parA==parB)return;

         if(sz[parA]>sz[parB]){
            par[parB]=parA;
            sz[parA]+=sz[parB];
         }
         else{
            par[parA]=parB;
            sz[parB]+=sz[parA];
         }

      }


     public List<List<String>> accountsMerge(List<List<String>> accounts){
        int n = accounts.size();
       int[] par = new int[n];
       int[] sz =new int[n];
        
       for(int i=0;i<n;i++){
          par[i] =i;
          sz[i] = accounts.get(i).size()-1;
       }
      
      Map<String,Integer> m = new Hashtable<>();

        for(int i=0;i<accounts.size();i++){
                List<String> l = accounts.get(i);
                for(int j=1;j<l.size();j++){
                      String email = l.get(j);
                      if(m.containsKey(email)){
                            unionSet(i,m.get(email),sz,par);
                            m.replace(email,getParent(i,par));
                      }else{
                        m.put(email,i);
                      }

                }
        }

        Map<Integer,SortedSet<String>> aa = new HashMap<>();
        
        for(int i =0;i<n;i++){
            int p = getParent(i,par);
            List<String> emails = accounts.get(i);
            
            if(!aa.containsKey(p)){
               aa.put(p, new TreeSet<>());
            }
            
            for(int j=1;j<emails.size();j++){
             aa.get(p).add(emails.get(j));
            }
        }
        List<List<String>> ans = new ArrayList<>();
       
       for(Map.Entry<Integer,SortedSet<String>> dd : aa.entrySet()){
         List<String> ee = new ArrayList<>();
         String name = accounts.get(dd.getKey()).get(0);
         ee.add(name);
         ee.addAll(dd.getValue());
        ans.add(ee);
       }

     return ans;
        
    }

}