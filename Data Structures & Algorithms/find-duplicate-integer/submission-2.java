class Solution {
    public int findDuplicate(int[] nums) {
        int slow,fast,n;
        n=nums.length;
        slow=nums[0];
        fast=nums[0];

        // finding common meeting point X.
        // c= length till entrance of cycle
        // X=meeting point in cycle , t = size of cycle
        // suppose after p steps   slow = c+x+kt  k>=0
        // fast = c+x+k't
        // if we take of modulo of both with t as we are in the cycle. (c+x)%t for both 
        // which confirms both will collide
        // now equate the equations 
        // 2(c+x+kt)=c+x+k't
        // c + x = (k'-2k)t
        // c+x = m't
        // c=(m'-1)t + (t-x)
        //  t-x -> rest of the length from meeting point x in the cycle 
        // after meeting at x if we start again from slow from start and another pointer from pointer x  
        // we will collide at entrance of cycle
        do{
       slow=nums[slow];
       fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
