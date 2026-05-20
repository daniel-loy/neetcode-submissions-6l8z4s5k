class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currentbuy = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                profit+=prices[i-1]-currentbuy;
                currentbuy = prices[i];
            }
        }
        if(currentbuy<prices[prices.length-1]){
            profit += prices[prices.length-1] - currentbuy;
        }
        return profit;
    }
}