class Solution {
private boolean checkInterLeaving(int a,int b,int c,String s1,String s2,String s3)
{
  if(a==s1.length() && b==s2.length())return true;

  if(a==s1.length())return false;

 if(s1.charAt(a)!=s3.charAt(c))return false;

 return checkInterLeaving(a+1, b, c+1, s1, s2, s3) || checkInterLeaving(b,a+1,c+1,s2,s1,s3);

}
 public boolean isInterleave(String s1, String s2, String s3) {
     
     if(s1.length()+s2.length()!=s3.length())return false;

     return checkInterLeaving(0, 0, 0, s1, s2, s3)||checkInterLeaving(0, 0, 0, s2, s1, s3);

    }

}
