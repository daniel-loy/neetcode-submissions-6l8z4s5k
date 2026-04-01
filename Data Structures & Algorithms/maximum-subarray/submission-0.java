class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int min = nums[0];
        int maxsofar = nums[0];

        for(int i=1;i<nums.length;i++){
            int temp = max;
            max =Math.max(Math.max(nums[i],max+nums[i]),min+nums[i]);
            min = Math.min(Math.min(nums[i],min+nums[i]),max+nums[i]);

            maxsofar = Math.max(maxsofar,max);
        }

        return maxsofar;
    }
}
