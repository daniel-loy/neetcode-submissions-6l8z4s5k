class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left]; // already sorted, no rotation
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= nums[right]) {
                left = mid + 1; // min is in the right half
            } else {
                right = mid;    // min is in the left half (including mid)
            }
        }

        return nums[left];
    }
}
