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
    private int ans = Integer.MIN_VALUE;
   private int solve(TreeNode t){
    if(t==null)
     return 0;
     int l= Math.max(0,solve(t.left));
     int r= Math.max(0,solve(t.right));
     ans=Math.max(ans,l+r+t.val);
     return t.val + Math.max(l,r);
     }
    

    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
}
