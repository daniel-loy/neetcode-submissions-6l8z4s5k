class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
	int buy = prices[0];
	for(int i=1;i<prices.length;i++){
	  if( prices[i]<buy){
		buy = prices[i];
	}
	else{
	       maxprofit = Math.max(prices[i] - buy,maxprofit);
	}
	}
	return maxprofit;
    }
}