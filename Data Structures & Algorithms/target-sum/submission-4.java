class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum=0;
        for(int num : nums){
            sum +=num;
        }

                if ((target + sum) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int positivenum = (target+sum)/2;
        int[] dp = new int[positivenum+1];
        dp[0]=1;
        for(int num : nums){
            for(int i=positivenum;i>=num;i--){
                    dp[i]+=dp[i-num];
                
            }
        }
        return dp[positivenum];
    }
}
