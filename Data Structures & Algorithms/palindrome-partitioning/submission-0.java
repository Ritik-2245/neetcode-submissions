class Solution {
  private boolean checkPalindrome(StringBuilder s){
         
    for(int i=0;i<s.length()/2;i++){
        if(s.charAt(i)!=s.charAt(s.length()-1-i))
            return false;
    }
return true;
    }

    private void solve(List<List<String>> ans,List<String> cur,int ind,String s){
        if(ind==s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
StringBuilder sb=new StringBuilder();
        for(int i=ind;i<s.length();i++){
             sb.append(s.charAt(i));
             if(checkPalindrome(sb)){
                cur.add(sb.toString());
                solve(ans,cur,i+1,s);
                cur.removeLast();
             }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(ans,new ArrayList<>(),0,s);
        return ans;
    }
}
