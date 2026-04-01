class Solution {
    public boolean canJump(int[] nums) {
        int maxindexreachable = 0;
        if(nums.length==1){
            return true;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0 && maxindexreachable <= i){
                return false;
            }
            int maxindex = nums[i]+i;
            System.out.println(maxindex);

            if(maxindex >= nums.length-1){
                return true;
            }
            if(maxindex > maxindexreachable){
                maxindexreachable = maxindex;
            }
        }

        return false;
    }
}
