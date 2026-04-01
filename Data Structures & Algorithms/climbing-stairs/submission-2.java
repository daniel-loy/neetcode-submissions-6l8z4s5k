class Solution {
    public int climbStairs(int n) {
        int[] starts = new int[n+1];

	starts[0]=1;
	starts[1]=1;

	for(int i=2;i<=n;i++){
	   starts[i]=starts[i-1]+starts[i-2];
	}

	return starts[n];
    }
}