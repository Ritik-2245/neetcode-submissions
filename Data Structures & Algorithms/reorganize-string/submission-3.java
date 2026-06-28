class Solution {
    public String reorganizeString(String s) {
        
        int[] fr = new int[26];
        for(char c:s.toCharArray())
            fr[c-'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0], a[0]));

// Queue<Character> q = new LinkedList<>();
int mx= (s.length()+1)/2 + 1;
for(int i=0;i<26;i++){
    if(fr[i]>=mx)return "";
    if(fr[i]>0){
            pq.add(new int[]{fr[i],i});    
    }
    }

   StringBuilder sb = new StringBuilder();
    int[] prev=null;

    while(!pq.isEmpty()){
        int[] cur = pq.poll();
        sb.append((char)(cur[1]+'a'));
        cur[0]--;

        if(prev!=null && prev[0]>0)
            pq.offer(prev);
        prev=cur;
    }


return sb.toString();


    }

}