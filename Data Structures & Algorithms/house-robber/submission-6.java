class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int one = nums[0];
        int two = nums[1];
        for(int i=2;i<nums.length;i++){
            int current = one+nums[i];
            one = Math.max(one,two);
            two = current;
        }

        return Math.max(two,one);
    }
}
