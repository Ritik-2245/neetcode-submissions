class WordDictionary {

private Trie head;
static class Trie{
    boolean end;
    Trie[] next;

    Trie(){
        next=new Trie[26];
    }
}

    public WordDictionary() {
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

    private boolean search(String s,int ind,Trie t){
           
           if(s.charAt(ind)=='.'){
                for(int i=0;i<26;i++)
                    if(t.next[i]!=null)
                    {
                        if(ind!=s.length()-1){
                            if(search(s,ind+1,t.next[i]))return true;
                        }else{
                            if(t.next[i].end)return true;
                        }
                    }
           return false;
           }

        int y=s.charAt(ind)-'a';

        if(t.next[y]==null)
            return false;

        if(ind==s.length()-1){
            return t.next[y].end;
            
        }
        return search(s,ind+1,t.next[y]);
    }


    public void addWord(String word) {
          this.insert(word);
    }

    public boolean search(String word) {
 if(word.isEmpty())return true;
        return search(word,0,head);
    }
}