class Solution {
      private boolean co[],diag[],antiDiag[];

  private boolean checkValid(List<StringBuilder> s,int row,int col,int n){
                
             return !(co[col]|diag[row-col+n-1]|antiDiag[row+col]);
                
    }

    private void solve(int ind,int n,List<List<String>> ans,List<StringBuilder> cur){
          if(ind==n){
            ans.add(cur.stream().map(StringBuilder::toString).toList());return;
          }


          for(int i=0;i<n;i++){
              if(checkValid(cur,ind,i,n)){

                co[i]=diag[ind-i+n-1]=antiDiag[ind+i]=true;
                cur.get(ind).setCharAt(i, 'Q');
                solve(ind+1,n,ans,cur);
                cur.get(ind).setCharAt(i, '.');
                co[i]=diag[ind-i+n-1]=antiDiag[ind+i]=false;
              }

          }
    }



     public List<List<String>> solveNQueens(int n) {
       
         List<List<String>> ans = new ArrayList<>();
        //  StringBuilder row= new StringBuilder(".".repeat(n));
         List<StringBuilder> cur = new ArrayList<>();
          co=new boolean[n];
          diag=new boolean[2*n-1];
          antiDiag=new boolean[2*n-1];
         String qq=".".repeat(n);
        for(int i=0;i<n;i++)
        cur.add(new StringBuilder(  qq));
        solve(0,n,ans,cur);
        return ans;


    }



}
