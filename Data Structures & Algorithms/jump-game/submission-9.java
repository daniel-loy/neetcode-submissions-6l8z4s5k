class Solution {
    public boolean canJump(int[] nums) {

        int max = 0;

        for(int i = 0; i < nums.length; i++) {

            // ❗ If current index is not reachable
            if(i > max) {
                return false;
            }

            // Update farthest reach
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }
}