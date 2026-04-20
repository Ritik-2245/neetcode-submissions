/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

   private void dfs(Node node,Node[] gr,int[] check){

check[node.val] =0;

     Node cur = gr[node.val];

     for(Node neig:node.neighbors){
           cur.neighbors.add(gr[neig.val]);
           if(check[neig.val]==1)
           dfs(neig,gr,check);
     }

   }

    public Node cloneGraph(Node node) {
       if(node == null) return null;
         
        Node[] gr = new Node[101];
        int[] check = new int[101];

        for(int i=1;i<=100;i++){
            gr[i] = new Node(i);
            check[i] = 1;
        }
        dfs(node,gr,check);

        return gr[node.val];
    }
}