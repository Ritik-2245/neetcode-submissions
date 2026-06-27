class Solution {
  
    public static class Trie{
     boolean end;
     Trie[] next;

     Trie(){
        next=new Trie[26];
     }
    }

public static class TrieTree{
   Trie head;

   TrieTree(){
    head=new Trie();
   }

   public void insert(String s){
      build(s,head,0);
   }
   public void insertAll(List<String> wordlist){
    for(String e:wordlist)
        insert(e);
   }

   private void build(String s,Trie t,int i){
    int y= s.charAt(i)-'a';
    if(t.next[y]==null){
        t.next[y]=new Trie();
    }
         if(i==s.length()-1){
            t.next[y].end=true;
            return;
         }
       build(s,t.next[y],i+1);
   }

   public List<Integer> findInd(String s,int y){
    List<Integer> ans=new ArrayList<>();
              checkInd(s, y, ans, head);
    return ans;
   }

   private void checkInd(String s,int y,List<Integer> ans,Trie t){
    if(y==s.length()){
        return;
    }
     int u=s.charAt(y)-'a';
     if(t.next[u]==null)return;
     if(t.next[u].end){ans.add(y+1);}
                checkInd(s, y+1, ans, t.next[u]);
   }
 
}

TrieTree tree;
List<String>[] sol;

private void mergeList(List<String> f,String w,List<String> q)
{
    for(String t:q)
        f.add(w+(t.length()==0 ? "":" ")+t);
}
private List<String> solve(String s,int ind){
     if(ind==s.length())return List.of("");

    if(!sol[ind].isEmpty()){
        return sol[ind];
    }

    List<Integer> indexes= tree.findInd(s, ind);

    // List<String> res=new ArrayList<>();

    for(int ne:indexes){
        String r= s.substring(ind,ne);
        mergeList(sol[ind], r, solve(s,ne));
    }

return sol[ind];
   
}

public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans =new ArrayList<>();
        tree=new TrieTree();
        tree.insertAll(wordDict);
        sol= new ArrayList[s.length()];
        for(int i=0;i<s.length();i++)sol[i]= new ArrayList<>();
               
              return solve(s,0);
                
    }

}