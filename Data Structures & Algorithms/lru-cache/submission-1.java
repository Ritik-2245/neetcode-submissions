

class LRUCache {

private static class Node {
   int key;
   int value;
   Node next;
   Node prev;
   Node(int k,int v){
    key=k;
    value=v;
   }
}

private Node head,end;
private int capacity;
private Map<Integer,Node> hm;
    public LRUCache(int capacity) {
        head=new Node(-1,-1);
        end = new Node(-1,-1);
        head.next=end;
        end.prev=head;
        hm=new HashMap<Integer,Node>();
        this.capacity=capacity;
    }

    private void insert(Node node){
      Node ne = head.next;
      head.next=node;
      node.prev=head;
      ne.prev=node;
      node.next=ne;
    }

    private void delete(Node node){
       Node pre=node.prev;
       Node ne = node.next;
       pre.next=ne;
       ne.prev=pre;
    }
    private void deletePermanently(Node node){
        hm.remove(node.key);
        delete(node);
    }
    private void createNode(int k,int v){
         if(hm.size()==capacity)
            deletePermanently(end.prev);
        Node r=new Node(k,v);
        hm.put(k,r);
        insert(r);
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
       Node t=hm.get(key);
       delete(t);
       insert(t);
       return t.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node g=hm.get(key);
            g.value=value;
             delete(g);
             insert(g);
        }else{
            createNode(key,value);
        }
    }
}
