class Solution {
private void solve(List<String> ans,int ind,String s,StringBuilder sb,List<String> dict){
    if(ind==s.length()){ 
        
        ans.add(sb.substring(0, sb.length()-1).toString());return;
    }

    for(String r:dict){

        int y=ind;
        int i=0;

        while(y<s.length() && i<r.length() && s.charAt(y)==r.charAt(i)){
            i++;
            y++;
        }
        if(i!=r.length())continue;

        sb.append(r);
        sb.append(" ");
        solve(ans,y,s,sb,dict);
        sb.deleteCharAt(sb.length()-1);
        sb.delete(sb.length()-r.length(), sb.length());
    }


}

public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans =new ArrayList<>();
        solve(ans,0,s,new StringBuilder(),wordDict);
        return ans;
    }

}