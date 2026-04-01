class Solution {
    public int maxProduct(int[] nums) {
            int maxsize = nums[0];
            int minsize = nums[0];
            int result = maxsize;

            for(int i=1;i<nums.length;i++){

                if(nums[i]<0){
                    int temp = maxsize;
                    maxsize=minsize;
                    minsize=temp;
                }
                
                maxsize = Math.max(nums[i],maxsize*nums[i]);
                minsize = Math.min(nums[i],minsize*nums[i]);
                result = Math.max(maxsize,result);
            }
            return result;
    }
}
