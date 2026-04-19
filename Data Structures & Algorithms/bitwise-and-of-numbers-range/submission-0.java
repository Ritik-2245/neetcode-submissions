class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int idx=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            idx++;
        }
        return left<<idx;
    }
}