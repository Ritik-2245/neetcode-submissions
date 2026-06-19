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
    private TreeNode ans=null;
    private boolean solve(TreeNode t,TreeNode p,TreeNode q){
        if(t==null)return false;
        boolean a = solve(t.left,p,q);
        boolean b=solve(t.right,p,q);
        if(a&b){
            ans=t;
            return true;
        }

        boolean e = ( t.val==p.val || t.val==q.val);
        
        if(e && (a|b)){
            ans=t;
            return true;
        }

        return e|a|b;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root,p,q);
        return ans;
    }
}
