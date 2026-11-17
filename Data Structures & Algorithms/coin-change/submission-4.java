class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] num = new int[amount + 1];

        Arrays.fill(num, amount + 1);

        num[0] = 0;

        for (int coin : coins) {

            for (int i = coin; i <= amount; i++) {

                num[i] = Math.min(num[i], num[i - coin] + 1);

            }
        }

        return num[amount] > amount ? -1 : num[amount];
    }
}