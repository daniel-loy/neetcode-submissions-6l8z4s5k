class Solution {
    public boolean canPartition(int[] nums) {
        int max = 0;
        for(int num : nums){
            max+=num;
        }
        if(max%2 != 0){
            return false;
        }
        int target = max/2;


        boolean[] dp = new boolean[target+1];

        dp[0]=true;

        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                if(nums[i]<=j && !dp[j]){
                    dp[j]=dp[j-nums[i]];
                }
            }
        }

        return dp[target];
    }
}

