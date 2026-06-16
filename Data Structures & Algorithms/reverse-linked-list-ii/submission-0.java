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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy= new ListNode(0);
        ListNode cur= dummy;
        dummy.next=head;
        right-=left;

        while(left>1)
        {
            cur=cur.next;
            left--;
        }
        ListNode start,end;
        start=cur.next;
        end=cur.next;
        while(right>0){
end=end.next;
right--;   
        }
        ListNode rest=end.next;
        end.next=null;

        cur.next=reverseList(start);
        start.next=rest;
return dummy.next;

    }
}