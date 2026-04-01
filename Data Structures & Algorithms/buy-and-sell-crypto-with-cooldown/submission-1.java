class Solution {
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length+1];
        int[] sell = new int[prices.length+1];
        int[] rest = new int[prices.length+1];


        buy[1]= buy[0]-prices[0];
        for(int i=2;i<prices.length+1;i++){
            buy[i]=Math.max(buy[i-1],rest[i-1]-prices[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i-1]);
            rest[i]=Math.max(sell[i-1],rest[i-1]);
        }

        return Math.max(sell[prices.length],rest[prices.length]);
    }
}
