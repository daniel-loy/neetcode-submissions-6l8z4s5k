class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }

        if(sum%2 != 0){
            return false;
        }
        int target = sum/2;

        boolean[] arr = new boolean[target+1];

        
        arr[0] = true;

        for(int num : nums){
            for(int i=target;i>=1;i--){
                if(num>i){
                    break;
                }
                if(arr[i-num]){
                    arr[i] = true;
                }
            }
        }

        return arr[target];
    }
}
