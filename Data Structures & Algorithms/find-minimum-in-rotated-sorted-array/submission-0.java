class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                return nums[i];
            }
        }
        return nums[0];
    }
}
