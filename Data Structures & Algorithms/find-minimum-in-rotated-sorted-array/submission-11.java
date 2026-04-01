class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int minvalue = Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left+right)/2;
            minvalue = Math.min(minvalue,nums[mid]);
            if(nums[mid]>nums[right]){
                                left = mid+1;
            }
            else{
                                right = mid-1;
            }
        }

        return minvalue;
    }
}
