/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<List<Integer>> ans=new ArrayList<>();

        while(!q.isEmpty() && q.peek()!=null){

            List<Integer> tt=new ArrayList<>();
             
            do{
              TreeNode cur=q.poll();
              tt.add(cur.val);
              if(cur.left!=null)
              q.offer(cur.left);
              if(cur.right!=null)
              q.offer(cur.right);

            }while(q.peek()!=null);
               ans.add(tt);
               q.poll();
               q.offer(null);            

        }
return ans;
    }
}
