
class LFUCache {

    private static class Node{
        int key;int value;int counter;
        Node prev,next;
        Node(int key,int value){
             this.key=key;
             this.value=value;
             counter=0;
        }
        Node(){
            counter=0;
            this.key=-1;
            this.value=-1;
        }

        boolean isEmpty(){
            return key==-1;
        }
    }

private static class DLL{
    Node head,end;

    DLL(){
        head=new Node();
        end=new Node();
     head.next=end;
     end.prev=head;
    }

    void addNode(Node node){
        Node ne=head.next;
        head.next=node;
        node.prev=head;
        node.next=ne;
        ne.prev=node;
    }

    int removeNode(){
        Node toBeRemoved = end.prev;
        Node pre=end.prev.prev;

        end.prev=pre;
        pre.next=end;
        return toBeRemoved.key;
    }

    boolean isEmpty(){
        return head.next==end;
    }
}

    private int capacity;
    Map<Integer,Node> hm;
    Map<Integer,DLL> freq;
    private int minFreq=1;
   

    // least frequently used

    public LFUCache(int capacity) {
        this.capacity=capacity;
        hm=new HashMap<>();
        freq=new HashMap<>();
    }

    private void deleteNode(Node node){
        Node pre=node.prev;
        Node ne=node.next;
        pre.next=ne;
        ne.prev=pre;
        hm.remove(node.key);
    }

    
    private void addNode(Node node){
        if(hm.size()==capacity){
           int k = freq.get(minFreq).removeNode();
           hm.remove(k);
        }
         int y=node.counter; 
         node.counter++; 
         freq.putIfAbsent(node.counter, new DLL());
         DLL pp = freq.get(node.counter);
         hm.putIfAbsent(node.key,node);
        pp.addNode(node);
         
         if(y== minFreq && freq.getOrDefault(minFreq,new DLL()).isEmpty()){
            minFreq++;
         }else
           minFreq=Math.min(minFreq,node.counter);
         
    }



    
    public int get(int key) {
        if(!hm.containsKey(key))return -1;
        Node t=hm.get(key);
         deleteNode(t);
         addNode(t);
         return t.value;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node t=hm.get(key);
            deleteNode(t);
            t.value=value;
            addNode(t);
        }else{
            addNode(new Node(key,value));
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */