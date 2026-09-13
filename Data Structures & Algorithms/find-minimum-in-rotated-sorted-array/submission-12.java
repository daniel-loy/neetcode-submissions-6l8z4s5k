class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left=0;
        int right = nums.length-1;
        int mid=0;
        while(left<=right){
            mid = (right+left)/2;
            min = Math.min(nums[mid],min);
            if(nums[mid] < nums[right])
            {
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        
        }
        return min;
    }
}
