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

   private int solve(TreeNode t,int max){
    if(t==null) return 0;
     
     return (t.val>=max ? 1 :0) + solve(t.left,Math.max(max,t.val))+solve(t.right,Math.max(max,t.val));

   }


    public int goodNodes(TreeNode root) {
        return solve(root,-200);
    }
}
