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
     
private boolean solve(TreeNode t,int low,int high){
    if(t==null)return true;
    
    if(t.val<=low || t.val>= high)return false;

    if(!solve(t.left,low,t.val))return false;
    if(!solve(t.right,t.val,high))return false;

    return true;


}

    public boolean isValidBST(TreeNode root) {
     return solve(root,-1001,1001);
    }
}
