/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode reverseList(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        
      

        ListNode cur = head;
        int t=k-1;

        while(t>0 && cur!=null){
            cur=cur.next;
            t--;
        }
        if(t!=0 || cur==null)return head;
        ListNode endNode = cur;
        ListNode newStart = reverseKGroup(cur.next,k);
        cur.next=null;
        ListNode newhead = reverseList(head);
        head.next=newStart;

return endNode;
        
    }
}
