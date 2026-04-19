class Solution {
public long minEnd(int n, int x) {
        long ans =x;
        n--;
            int j=0;
            for(int i=0;i<64;i++){
                  if((x&(1l<<i))==0){
                     

                     if((n&(1l<<j))!=0){
                             ans |= (1l<<i);
                     }

                  	j++;
                  }                  

            }

        return ans;

    }
}