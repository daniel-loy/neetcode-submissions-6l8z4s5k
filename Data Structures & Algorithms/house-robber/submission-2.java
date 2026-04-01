class Solution {
    public int rob(int[] nums) {
        int maxsofar=0;
        if(nums.length==1){
            return nums[0];
        }
        
        int prev1=nums[0];
        int prev2=nums[1];
        maxsofar=prev1;
        int cost;
        for(int i=2;i<nums.length;i++){
            int current = nums[i]+maxsofar;
            maxsofar = Math.max(maxsofar,prev2);
            prev1=prev2;
            prev2=current;
        }

        return Math.max(prev1,prev2);
    }
}
