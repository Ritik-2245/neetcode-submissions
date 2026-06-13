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

    public ListNode reverseList(ListNode head) {

   if(head==null || head.next==null)return head;

   ListNode cur,ne,tmp;
   cur=head;
   ne=cur.next;
   
   while(ne!=null){
     tmp=ne.next;
     ne.next=cur;
     cur=ne;
     ne=tmp;
    }
    head.next=null;
return cur;

}
}