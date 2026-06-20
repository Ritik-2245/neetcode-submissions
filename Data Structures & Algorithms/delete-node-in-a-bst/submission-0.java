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

    private TreeNode findSuccessor(TreeNode t){
        t=t.right;
        while(t!=null && t.left!=null){
            t=t.left;
        }
        return t;
    }

    // private TreeNode delete(TreeNode t,int k){
        

    // }

    public TreeNode deleteNode(TreeNode t, int k) {
        if(t==null)return null;
          
          if(k>t.val){
            t.right=deleteNode(t.right,k);
            return t;
          }
          
          if(k<t.val){
            t.left=deleteNode(t.left,k);
            return t;
          }


          if(t.left==null)return t.right;
          if(t.right==null)return t.left;


          TreeNode replace = findSuccessor(t);

          replace.right=deleteNode(t.right,replace.val);
          replace.left=t.left;
          return replace;
    }
}