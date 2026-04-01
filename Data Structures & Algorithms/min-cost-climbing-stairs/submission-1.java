class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
	int[] mincost = new int[n];
	mincost[0]=cost[0];
	mincost[1]=cost[1];
	for(int i=2;i<n;i++){
		mincost[i]=Math.min(mincost[i-1],mincost[i-2])+cost[i];
        System.out.println(i+" "+mincost[i]);
	}
	return Math.min(mincost[n-1],mincost[n-2]);
    }
}