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

    private ListNode mergeTwoList(ListNode a,ListNode b){
        if(a==null)return b;
        if(b==null)return a;

        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
          
          while(a!=null && b!=null){
            if(a.val<b.val){
                cur.next=a;
                a=a.next;
            }else{
                cur.next=b;
                b=b.next;
            }
            cur=cur.next;
          }
          if(a==null)
          cur.next=b;
          if(b==null)
          cur.next=a;
          return dummy.next;
    }

  private ListNode ListNodeMerge(int start,int end,ListNode[] lists){
    if(start>end)return null;
      if(start==end)return lists[start];
      
      int mid = start + (end-start)/2;
      ListNode l=ListNodeMerge(start,mid,lists);
      ListNode r =ListNodeMerge(mid+1,end,lists);

      return mergeTwoList(l,r);

  }


    public ListNode mergeKLists(ListNode[] lists) {
return ListNodeMerge(0,lists.length-1,lists);
    }
}
