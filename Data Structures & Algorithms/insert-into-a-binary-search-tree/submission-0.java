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
    
   
    public TreeNode insertIntoBST(TreeNode t, int val) {
    if(t==null)return new TreeNode(val);
        if(val>t.val){
            t.right=insertIntoBST(t.right,val);
        }else{
            t.left=insertIntoBST(t.left,val);
        }
        return t;

    }
}