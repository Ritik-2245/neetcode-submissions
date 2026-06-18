class MyCircularQueue {

 public static class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    
}

private ListNode start,end;
private int size,cur=0;

    public MyCircularQueue(int k) {
        size=k;
      ListNode first = new ListNode();    
      start=first;
      end=first;
      for(int i=0;i<k-1;i++){
        first.next=new ListNode();
        first.next.prev=first;
        first=first.next;
      }
      first.next=start;
      start.prev=first;


    }
    
    public boolean enQueue(int value) {
        if(cur>=size)return false;
        end.val=value;
        end=end.next;
        cur++;
        return true;
    }
    
    public boolean deQueue() {
        if(cur==0)return false;
        start=start.next;
        cur--;
        return true;
    }
    
    public int Front() {
        if(cur==0)return -1;

        return start.val;
    }
    
    public int Rear() {
        if(cur==0)return -1;
        return end.prev.val;
    }
    
    public boolean isEmpty() {
        return cur==0;
    }
    
    public boolean isFull() {
        return cur==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */