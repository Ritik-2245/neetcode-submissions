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
       if(head==null||head.next==null)return head;

       ListNode newHead=reverseList(head.next);
       head.next.next=head;
       head.next=null;
       return newHead;
    }

    public void reorderList(ListNode head) {
          //base case
          if(head==null||head.next==null)return;
          //mid point 
          ListNode cur,fast;
          cur=head;
          fast=head.next.next;

          while(fast!=null && fast!=null){
            cur=cur.next;
            if(fast.next==null)break;
            fast=fast.next.next;
          }
  
  ListNode revList=reverseList(cur.next);
  cur.next=null;
    ListNode ans=head;

   while(head!=null && revList!=null){
    ListNode tmp;
    tmp=head.next;
    head.next=revList;

    revList=revList.next;
    head.next.next=tmp;
    head=tmp;
   }
// if(revList!=)
    // return head;


    }
}
