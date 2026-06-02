class Solution {
private int arr[],sz,dp[][];

private int LTS(int ind,int prev_ind){

if(ind==sz)return 0;

if(dp[ind][prev_ind+1]!=-1)return dp[ind][prev_ind+1];

int len = LTS(ind+1,prev_ind);

if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
    len= Math.max(len,1+LTS(ind+1,ind));
}
return dp[ind][prev_ind+1]=len;
}


public int lengthOfLIS(int[] nums) {
        arr=nums;
        sz=nums.length;
        dp = new int[sz][sz];

        for(int i=0;i<sz;i++)
        for(int j=0;j<sz;j++)
        dp[i][j]=-1;

        return LTS(0,-1);
    }

}
