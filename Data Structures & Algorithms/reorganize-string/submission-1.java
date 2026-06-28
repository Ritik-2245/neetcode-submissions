class Solution {
    public String reorganizeString(String s) {
        
        int[] fr = new int[26];
        for(char c:s.toCharArray())
            fr[c-'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));

Queue<Character> q = new LinkedList<>();
int mx= (s.length()+1)/2 + 1;
for(int i=0;i<26;i++){
    if(fr[i]>=mx)return "";
    if(fr[i]>1){
            pq.add(new int[]{fr[i],i});    
    }
    if(fr[i]==1){
        q.offer((char)(i+'a'));
    }}

   StringBuilder sb = new StringBuilder();

   List<int[]> tmp=new ArrayList<>();
   
   while(!pq.isEmpty() || !q.isEmpty()){
    tmp.clear();

    while(!pq.isEmpty()){
        int[] cur = pq.poll();
        sb.append((char)(cur[1]+'a'));
        cur[0]--;
        tmp.add(cur);
    }

    for(int[] w:tmp)if(w[0]!=0)pq.offer(w);

    if(!q.isEmpty())sb.append(q.poll());
   }

   

return sb.toString();


    }


}