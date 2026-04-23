class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int returnvalue = max;
        for(int i=1;i<nums.length;i++){
            max = Math.max(nums[i],max+nums[i]);
            returnvalue = Math.max(max,returnvalue);
        }

        return returnvalue;
    }
}
