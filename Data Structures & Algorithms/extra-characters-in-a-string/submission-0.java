
class Solution {

static class Trie{
    boolean end;
    Trie[] next;
    Trie(){
        next=new Trie[26];
    }
}

static class PrefixTree{
private Trie head;
    
    PrefixTree(){
        head=new Trie();
    }

    void insert(String s,int ind,Trie t){
        int y=s.charAt(ind)-'a';

        if(t.next[y]==null)
            t.next[y]=new Trie();

        if(ind==s.length()-1){
            t.next[y].end=true;
            return;
        }

        insert(s,ind+1,t.next[y]);
    }

    void insertAll(String[] dict){
        for(String e:dict){
            if(e.isEmpty())
                continue;
            insert(e,0,head);
        }
    }

    List<Integer> getInd(String s,int ind){
        List<Integer> all=new ArrayList<>();
     search(s,ind,all,head);
     return all;
    }

    void search(String s,int ind,List<Integer> indices,Trie t){
        if(ind==s.length())return;
        int y=s.charAt(ind)-'a';

        if(t.next[y]==null)return ;
        
        if(t.next[y].end)indices.add(ind+1);
          search(s, ind+1, indices, t.next[y]);
    }
}

PrefixTree tree= new PrefixTree();
private int[] dp;
private int solve(int ind,String s){
    if(ind==s.length())return 0;
    if(dp[ind]!=Integer.MAX_VALUE)return dp[ind];
     int ans= Integer.MAX_VALUE;
    
    List<Integer> indices = tree.getInd(s, ind);

    for(int e:indices){
        ans=Math.min(ans,solve(e,s));
    }
     ans= Math.min(ans,solve(ind+1,s)+1);
    return dp[ind]=ans;
}


    public int minExtraChar(String s, String[] dictionary) {
        tree.insertAll(dictionary);
        dp=new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
       return solve(0,s);
    }
}