class Solution {
    private char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

private String StringFromNumber(int num){
  StringBuilder builder = new StringBuilder();
  int r= 1000;

   while(r>0){
    int i=num/r;
    builder.append(numbers[i]);
    num %= r;
    r/=10;
   }
   return builder.toString();
}  

private List<Integer> neigbhors(int p){
    List<Integer> ans = new ArrayList<>();
    StringBuilder builder = new StringBuilder(StringFromNumber(p));
    for(int i=0;i<4;i++){
        char a = builder.charAt(i);
        int d = a -'0';
        d++;
        builder.setCharAt(i,numbers[d%10]);
        ans.add(Integer.valueOf(builder.toString()));
        d-=2;d+=10;
        builder.setCharAt(i,numbers[d%10]);
        ans.add(Integer.valueOf(builder.toString()));
        builder.setCharAt(i,a);
    }

    return ans;
}


  public int openLock(String[] deadends, String target) {
       
        int[] dist = new int[10000];
         
        for(int i=0;i<10000;i++){
            dist[i] = 1000000; 
        }

  dist[0]=0;
    
     for(String s:deadends){
        int x =Integer.parseInt(s);
        if(x==0) return -1;
        dist[x] = -1;
     }

Queue<Integer> queue = new LinkedList<>();

queue.offer(0);

while(!queue.isEmpty()){
    int node = queue.poll();
   int d = dist[node];

  List<Integer> negih = neigbhors(node);
     
     for(Integer x:negih){
        if(dist[x]==-1)continue;

         if(dist[x]>d+1){
            dist[x]=d+1;
            queue.offer(x);
         }

     }

} 

int t= Integer.parseInt(target);



    return dist[t]!=1000000 ? dist[t]:-1;

    }

}