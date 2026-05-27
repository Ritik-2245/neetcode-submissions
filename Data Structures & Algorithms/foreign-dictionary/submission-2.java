class Solution {
   char[] getDiffer(String a,String b){
    int n = a.length(),m=b.length();
     int i=0;

     while(i<n && i<m){
        if(a.charAt(i)!=b.charAt(i)){
           return new char[]{a.charAt(i),b.charAt(i)};
        }
        i++;
     }
      return new char[]{' ',' '};
}


public String foreignDictionary(String[] words) {
  Map<Character,HashSet<Character>> gr = new HashMap<>();       
      int n = words.length;
      HashSet<Character> hs = new HashSet<>();
      
      for(int i=0;i<n;i++){
        for(char c: words[i].toCharArray())
            hs.add(c);
        for(int j=i+1;j<n;j++){
            char[] dd = getDiffer(words[i], words[j]);
            char a = dd[0];
            char b =dd[1];
               
            if(a == ' '){
                if(words[i].length()>words[j].length())return new String();
                continue;}

            gr.putIfAbsent(a, new HashSet<Character>());
            gr.get(a).add(b);
        }
      }
      Queue<Character> q = new LinkedList();

      StringBuilder builder = new StringBuilder();
      int[] indegree = new int[26];

      for(Map.Entry<Character,HashSet<Character>> m:gr.entrySet()){
        
        HashSet<Character> neig = m.getValue();
        for(char c :neig ){
            int ind = c-'a';
            indegree[ind]++;
        }
      }
for(char c:hs){
    if(indegree[c-'a']==0)
        q.offer(c);
}


while(!q.isEmpty())
{
    char c= q.poll();
    builder.append(c);

    if(!gr.containsKey(c))continue;
   for(char nei:gr.get(c)){
       int ind = nei - 'a';
       indegree[ind]--;
       if(indegree[ind]==0)q.offer(nei);
   }
   gr.remove(c);

}

    

      return builder.length()!=hs.size()? new String():builder.toString();
    }
}










