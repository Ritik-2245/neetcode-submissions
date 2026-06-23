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
    
    private int[] solve(TreeNode t){
        if(t==null) return new int[]{0,0};
        int[] l = solve(t.left);
        int[] r = solve(t.right);

        int consider = t.val + l[0]+r[0];
        int notConsidered = Collections.max(
Arrays.asList(l[1]+r[1],l[1]+r[0],l[0]+r[1],l[0]+r[0])
        );

        return new int[]{notConsidered,consider};
    }

    public int rob(TreeNode root) {
        return Arrays.stream(solve(root)).max().getAsInt();
    }

    
}