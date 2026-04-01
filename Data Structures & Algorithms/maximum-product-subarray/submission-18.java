class Solution {
    public int maxProduct(int[] nums) {
        int maxvalue = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                    int temp = max;
                    max=min;
                    min=temp;
            }
            max = Math.max(nums[i]*max,nums[i]);
            min = Math.min(nums[i]*min,nums[i]);
            maxvalue = Math.max(max,maxvalue);
        }

        return Math.max(Math.max(min,max),maxvalue);
        
    }
}
