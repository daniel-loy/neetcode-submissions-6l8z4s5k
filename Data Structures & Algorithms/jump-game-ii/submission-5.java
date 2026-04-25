class Solution {
    public int jump(int[] nums) {
        int prevmax =0;
        int max = 0;
        int result = 0;
        if(nums.length==1){
            return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if(prevmax == i){
                result++;
                prevmax = max;
                if(max>= nums.length-1){
                    return result;
                }
            }
            
        }

        return result;
    }
}