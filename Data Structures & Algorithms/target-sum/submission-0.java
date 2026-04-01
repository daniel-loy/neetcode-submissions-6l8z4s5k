class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        if((sum+target)%2 !=0){
            return 0;
        }
        int positivesum=(sum+target)/2;

        int[] dp = new int[positivesum+1];
        dp[0]=1;

        for(int n : nums){
            for(int i=positivesum ;i>=n;i--){
                dp[i]+=dp[i-n];
            }
        }

        return dp[positivesum];
    }
}
