class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            int max = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    int total = dp[i-coins[j]] == Integer.MAX_VALUE?Integer.MAX_VALUE : dp[i-coins[j]]+1;
                    max = Math.min(max,total);
                }
            }
            dp[i]=max;
            System.out.println(dp[i]);

        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
