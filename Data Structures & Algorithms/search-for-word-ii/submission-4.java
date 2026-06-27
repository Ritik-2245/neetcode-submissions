// import java.util.*;
// import java.util.*;
class Solution {

static class Trie{
    String word;
    Trie[] next;

    Trie(){
        next=new Trie[26];
    }
}
 private Trie head;

private void insert(String s,int ind,Trie t){
    int y=s.charAt(ind)-'a';
    if(t.next[y]==null){
        t.next[y]=new Trie();
    }

    if(ind==s.length()-1){
        t.next[y].word=s;
        return;
    }

    insert(s,ind+1,t.next[y]);
}

 private void insertAll(String[] words){
  for(String e:words){
    insert(e,0,head);
  }
 }

 private int[] xMove= new int[]{-1,1,0,0};
 private int[] yMove= new int[]{0,0,-1,1};

 private int n,m;
 private List<String> ans;

 private boolean isValid(int x,int y,char[][] B){

     return x>-1 && x<n && y>-1 && y<m && B[x][y]!='*';
 }

private boolean solve(char[][] board,int x,int y,Trie h){
       int ind=board[x][y]-'a';
            boolean flag=false;
       if(h.next[ind]==null)return flag;
       char tmp = board[x][y];
          board[x][y]='*';
          if(h.next[ind].word!=null){
            ans.add(h.next[ind].word);
              h.next[ind].word=null;
        }
       for(int i=0;i<4;i++){

        int a=x+xMove[i];
        int b= y+yMove[i];
            if(isValid(a,b,board)){
            flag |=solve(board,a,b,h.next[ind]);
            }


       }
       board[x][y]=tmp;
   return flag;
}


    public List<String> findWords(char[][] board, String[] words) {
        n=board.length;
        m=board[0].length;
        head=new Trie();
        ans=new ArrayList<>();
        insertAll(words);

       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++)
        // if(board[i][j]!='*')
            solve(board,i,j,head);
       }
       return ans;
        
    }

}
