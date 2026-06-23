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
    private int pr[],in[];

    private TreeNode build(int start,int end,int cur){
        if(start>end)return null;
        if(start==end)return new TreeNode(in[start]);
        int r = pr[cur];
        int e = start;

        while(e<=end && r!=in[e]){
             e++;
        }
        TreeNode root = new TreeNode(r);
        root.left = build(start,e-1,cur+1);
        root.right = build(e+1,end,cur+e-start+1);
return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pr=preorder;
        in=inorder;

        return build(0,pr.length-1,0);
    }
}
