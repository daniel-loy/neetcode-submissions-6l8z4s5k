class Solution {
    public int findDuplicate(int[] nums) {
        int index = 0;

        while(true)
        {
            if(nums[index]==0){
                return index;
            }
            int nextindex = nums[index];
            nums[index] = 0;
            index = nextindex;
        }
    }
}
