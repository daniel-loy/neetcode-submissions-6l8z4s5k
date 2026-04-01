class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int left = 0;
        int right=nums.length-1;
        if(nums[left]<nums[right]){
            return nums[left];
        }
        while(left<right){
           int mid=left+(right-left)/2;
           System.out.println(nums[mid]+" "+nums[left]+" "+nums[right]);
            if(nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return nums[left];
    }
}
