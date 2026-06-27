class Solution {
    private boolean checkValid(List<StringBuilder> s,int row,int col,int n){
                
                for(int i=row-1;i>-1;i--)
                    if(s.get(i).charAt(col)=='Q')return false;
                     int j=col-1;
                    for(int i=row-1;i>-1 && j>-1;i--)
                    if(s.get(i).charAt(j--)=='Q')return false;
                      j=col+1;

for(int i=row-1;i>-1 && j<n;i--)
                    if(s.get(i).charAt(j++)=='Q')return false;
return true;
                
    }


    private void solve(int ind,int n,List<List<String>> ans,List<StringBuilder> cur){
          if(ind==n){
            ans.add(cur.stream().map(StringBuilder::toString).toList());return;
          }

          for(int i=0;i<n;i++){
              if(checkValid(cur,ind,i,n)){
                cur.get(ind).setCharAt(i, 'Q');
                solve(ind+1,n,ans,cur);
                cur.get(ind).setCharAt(i, '.');
              }

          }
    }



     public List<List<String>> solveNQueens(int n) {
       
         List<List<String>> ans = new ArrayList<>();
        //  StringBuilder row= new StringBuilder(".".repeat(n));
         List<StringBuilder> cur = new ArrayList<>();
         String qq=".".repeat(n);
        for(int i=0;i<n;i++)
        cur.add(new StringBuilder(  qq));
        solve(0,n,ans,cur);
        return ans;


    }


}
