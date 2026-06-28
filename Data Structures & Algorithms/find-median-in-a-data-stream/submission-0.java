class MedianFinder {

    private PriorityQueue<Integer> sm,bg;

    public MedianFinder() {
        bg = new PriorityQueue<>();
        sm = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
            bg.offer(num);
        
    //  if(Math.abs(sm.size()-bg.size())>1)
   BalanceQueue();

    }
    
    private void BalanceQueue(){

        while(sm.size()<bg.size()){
           sm.offer(bg.poll());
       }
       
        if(sm.isEmpty()||bg.isEmpty())return;
        while(sm.peek()>bg.peek()){
            int tmp = sm.poll();
            sm.offer(bg.poll());
            bg.offer(tmp);
        }
    }

    public double findMedian() {
        int sz=sm.size()+bg.size();

        if(sz%2==1){
             if(sm.size()>bg.size())return sm.peek();
             else return bg.peek();
        }

        int sum = bg.peek()+sm.peek();

        return (double)sum/2;
    }
}