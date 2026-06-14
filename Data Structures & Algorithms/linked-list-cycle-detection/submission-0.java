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
 
 private boolean check(ListNode slow,ListNode fast){
   
   if(slow==null||fast==null)return false;
   if(slow==fast)return true;

   if(fast.next!=null)
   return check(slow.next,fast.next.next);

   return false;

 }
 
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;

        return check(head,head.next.next);
    }
}
