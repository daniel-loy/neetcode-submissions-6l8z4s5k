class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1 || nums.length == 0){
            return nums;
        }
        int[] forwardArray = new int[nums.length];
        int[] backArray = new int[nums.length];
        int[] Ans = new int[nums.length];
        forwardArray[0]=nums[0];
        backArray[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            forwardArray[i]=nums[i]*forwardArray[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            backArray[i]=nums[i]*backArray[i+1];
        }
        System.out.println(Arrays.toString(forwardArray));
        System.out.println(Arrays.toString(backArray));

        Ans[0]=backArray[1];
        Ans[nums.length-1]=forwardArray[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            Ans[i]=forwardArray[i-1]*backArray[i+1];
        }
        return Ans;
    }
}  
