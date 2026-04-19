class Solution {
  private boolean compare(Map<Character,Integer> m,String a,String b){
      int i=0,j=0,x=a.length(),y=b.length();

      while(i<x && j<y){
          char c = a.charAt(i);
          char d = b.charAt(j);

          if (m.get(c)>m.get(d))
            return false;
          
          if(m.get(c)<m.get(d))return true;

        i++;
        j++;
      }

      return x<y;

    }

public boolean isAlienSorted(String[] words, String order) {
        
Map<Character,Integer> m = new HashMap<>();
      
      for(int i=0;i<26;i++)
{
    Character c = order.charAt(i);
    m.put(c,i);
}
     
     int i=1;

     while(i<words.length){
        if(!compare(m,words[i-1],words[i]))return false;
        i++;
     }
return true;
    }
}