class PrefixTree {

private Trie head;
static class Trie{
    boolean end;
    Trie[] next;

    Trie(){
        next=new Trie[26];
    }
}

    public PrefixTree() {
         head=new Trie();
    }


    //void insert(String word) Inserts the string word into the prefix tree.

    private void insert(String s,int ind,Trie t){
        int y=s.charAt(ind)-'a';

        if(t.next[y]==null)
            t.next[y]=new Trie();

        if(ind==s.length()-1){
            t.next[y].end=true;
            return;
        }
        insert(s,ind+1,t.next[y]);
        
    }

    public void insert(String word) {
        if(word.isEmpty())return;
              this.insert(word,0,head);
    }


//boolean search(String word) Returns true 
//if the string word is in the prefix tree (i.e., was inserted before), and false otherwise.

    public boolean search(String word) {
        if(word.isEmpty())return true;
        return search(word,0,head);
         
    }
    private boolean search(String s,int ind,Trie t){
        int y=s.charAt(ind)-'a';

        if(t.next[y]==null)
            return false;

        if(ind==s.length()-1){
            return t.next[y].end;
            
        }
        return search(s,ind+1,t.next[y]);
    }

//boolean startsWith(String prefix) Returns true 
//if there is a previously inserted string word that has the prefix prefix, and false otherwise.

    public boolean startsWith(String prefix) {
if(prefix.isEmpty())return true;
return startsWith(prefix, 0, head);
    }

private boolean startsWith(String s,int ind,Trie t){
        int y=s.charAt(ind)-'a';

        if(t.next[y]==null)
            return false;

        if(ind==s.length()-1){
            return true;
            
        }
        return startsWith(s,ind+1,t.next[y]);
    }

}

