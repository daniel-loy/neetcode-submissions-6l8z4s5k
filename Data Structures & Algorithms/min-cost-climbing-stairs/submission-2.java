class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
	int[] mincost = new int[n];
    int one = cost[0];
    int two = cost[1];
	for(int i=2;i<n;i++){
        int temp = two;
		two = Math.min(one,two)+cost[i];
        one = temp;
	}
	return Math.min(one,two);
    }
}