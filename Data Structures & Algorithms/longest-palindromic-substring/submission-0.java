class Solution {
public String longestPalindrome(String s) {
        
   String ans = new String();
 int n=s.length();
   for(int i=0;i<n;i++){
    
    int j=i-1,k=i+1;
     while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
        j--;
        k++;
       
     }
     j++;
     
     String temp = s.substring(j, k);
     if(temp.length()>ans.length()){
        ans=temp;
     }

   }

    for(int i=1;i<n;i++){
    
    int j=i-1,k=i;
     while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
        j--;
        k++;
       
     }
     j++;
     
     String temp = s.substring(j, k);
     if(temp.length()>ans.length()){
        ans=temp;
     }

   }

return ans;
    }
}
