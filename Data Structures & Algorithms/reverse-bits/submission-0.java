class Solution {
    public int reverseBits(int n) {
        long ans =0;
for(int i=0;i<32;i++){
	

	if((n&1)!=0){
		ans += 1l << (31-i);
		System.out.println(ans);
	}
	n>>>=1;

}
  
    return (int)ans;
    }
}
