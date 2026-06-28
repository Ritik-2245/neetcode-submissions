class Solution {
    public int leastInterval(char[] tasks, int n) {
       int[] fr=new int[26];
       for(char r:tasks)
       fr[r-'A']++;
       Arrays.sort(fr);
       int maxPart=fr[25]-1;
       int totalSlot=maxPart*n;
        
        for(int i=24;i>=0;i--){
            totalSlot-=Math.min(fr[i],maxPart);
        }

        return totalSlot > 0 ? totalSlot + tasks.length : tasks.length;

    }
}
