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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     
     if(head==null)return head;
    //  if(head.next==null)return null;

     ListNode slow,fast,ans;
     slow=new ListNode();
     ans=slow;
     slow.next=head;
     fast=head;
     while(n>0){
        fast=fast.next;
        n--;
     }

     while(fast!=null){
        slow=slow.next;
        fast=fast.next;
     }

     slow.next=slow.next.next;

     return ans.next;

    } 
}
