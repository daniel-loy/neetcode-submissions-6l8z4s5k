class Solution {
    public int maxCoins(int[] nums) {
        int numslength = nums.length;
        int[][] dp = new int[numslength+2][numslength+2];
        int[] extension = new int[numslength+2];
        extension[0]=1;
        extension[numslength+1]=1;
        for(int i=1;i<=numslength;i++){
            extension[i] = nums[i-1];
        }

        for(int length = 1;length<=numslength;length++){
            for(int left = 1;left <= numslength - length + 1;left++){
                int right = left+length-1;

                for(int i=left;i<=right;i++){
                    int coin = extension[left-1]*extension[i]*extension[right+1];
                    coin+=dp[left][i-1]+dp[i+1][right];
                    dp[left][right] = Math.max(coin,dp[left][right]);
                }
            }
        }
        return dp[1][numslength];
    }
}
