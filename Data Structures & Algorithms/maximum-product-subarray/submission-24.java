class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int max = result;
        int min = result;

        for(int i=1;i<nums.length;i++){
            max = max*nums[i];
            min = min*nums[i];
            int tempmax = max;
            max = Math.max(nums[i],Math.max(max,min));
            min = Math.min(nums[i],Math.min(tempmax,min));
            result = Math.max(max,result);
        }

        return result;
    }
}
