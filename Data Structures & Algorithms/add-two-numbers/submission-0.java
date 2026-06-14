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

    private ListNode addList(ListNode a,ListNode b, int carry){
    
    if(a==null && b==null){
        if(carry>0)return new ListNode(carry);
        return null;
    }

    int sum=carry;
    if(a==null){
        a=b;
        b=null;
    }
    sum+=a.val;
    
    if(b!=null){
        sum+=b.val;
        b=b.next;
    }
    a.val=sum%10;
    a.next=addList(a.next,b,sum/10);
   return a;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addList(l1,l2,0);


    }
}
