/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
 private int gd[][],prGd[][],side;

private void createPrefixSum(){
    prGd = new int[side+1][side+1];

     for(int i=1;i<=side;i++)
        for(int j=1;j<=side;j++){
            prGd[i][j]=prGd[i-1][j]+prGd[i][j-1]+gd[i-1][j-1]-prGd[i-1][j-1];
        }
}

private int getSum(int x1,int x2,int y1,int y2)
{
    int sum = prGd[x2][y2]-prGd[x1-1][y1]-prGd[x1][y1-1]+prGd[x1][y1];
return sum;
}
private Node createQuadTree(int x1,int x2,int y1,int y2,int s){
    if(x1==x2)return null;
    int sum=prGd[x2][y2]-prGd[x1][y2]-prGd[x2][y1]+prGd[x1][y1];
    // int sum =
    // prGd[x2][y2]
    // - prGd[x1][y2]
    // - prGd[x2][y1]
    // + prGd[x1][y1];
    // for(int i=x1;i<x2;i++)
    //     for(int j=y1;j<y2;j++)
    //         sum+=gd[i][j];
   
   boolean isLeaf= (sum==0 || sum==s*s);

   if(isLeaf){
    return new Node(sum==0 ? false : true , isLeaf);
   }
   Node head = new Node(true,false);
   int midX = x1 + (x2-x1)/2;
   int midY = y1 + (y2-y1)/2;
   head.topLeft = createQuadTree(x1,midX,y1,midY,s/2);
   head.topRight = createQuadTree(x1, midX, midY, y2, s/2);
   head.bottomLeft = createQuadTree(midX, x2, y1, midY, s/2);
   head.bottomRight =  createQuadTree(midX, x2, midY, y2, s/2);

   return head;

}

 public Node construct(int[][] grid) {
        gd=grid;
        side=grid.length;
        createPrefixSum();
        
        return createQuadTree(0, side, 0, side, side);
   
    }

}