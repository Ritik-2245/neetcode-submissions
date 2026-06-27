class Solution {
    private void solve(int n,List<String> ans,StringBuilder sb,int l,int c){
        if(sb.length()>2*n)return;
     	if(sb.length()==2*n){
     		ans.add(sb.toString());
     		return;
     	}

        if(l<n){
            sb.append('(');
            solve(n,ans,sb,l+1,c);
            sb.deleteCharAt(sb.length()-1);
        }

        if(c<l){
            sb.append(')');
            solve(n,ans,sb,l,c+1);
                sb.deleteCharAt(sb.length()-1);
        }
           
     } 


	 public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,ans,new StringBuilder(),0,0);
        return ans;
    }
}
