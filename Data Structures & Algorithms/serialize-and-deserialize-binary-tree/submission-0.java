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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    private void preorder(TreeNode t,StringBuilder s){
        if(t==null){
            s.append("#,");
            return;
        }
        s.append(t.val).append(",");
        preorder(t.left,s);
        preorder(t.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        
        return build(arr,new int[]{0});
    }
    private TreeNode build(String[] a,int[] i){
        if(a[i[0]].equals("#")){
            i[0]++;
            return null;
        }

        TreeNode r= new TreeNode(Integer.parseInt(a[i[0]++]));
        r.left=build(a,i);
        r.right=build(a,i);
        return r;
    }
}
