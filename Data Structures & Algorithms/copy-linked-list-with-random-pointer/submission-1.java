/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        //inserting nodes
        Node cur=head;

        while(cur!=null){
         Node nextNode=cur.next;
         Node copyNode=new Node(cur.val);
         cur.next=copyNode;
         copyNode.next=nextNode;
         cur=nextNode;
        }

        //setting random var
        cur=head;

        while(cur!=null){
             if(cur.random!=null){
                cur.next.random=cur.random.next;
             }
           cur=cur.next.next;
        }

        Node dummy = new Node(0);
        cur=dummy;
         while(head!=null){
            cur.next=head.next;
            head.next=head.next.next;
            head=head.next;
            cur=cur.next;
         }
         cur.next=null;


        return dummy.next;

    }
}
