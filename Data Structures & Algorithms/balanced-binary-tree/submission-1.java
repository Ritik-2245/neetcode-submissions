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
    private boolean ans=true;

    private int solve(TreeNode t){
        if(t==null)return 0;
        int l = solve(t.left);
        int r = solve(t.right);

        ans=ans&(Math.abs(l-r)<=1);
        return 1+Math.max(l,r);
    }
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return ans;
    }
}
