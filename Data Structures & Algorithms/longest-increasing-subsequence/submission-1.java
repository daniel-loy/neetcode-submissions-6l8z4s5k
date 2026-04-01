class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] subset = new int[nums.length+1];
        Arrays.fill(subset,1);
        int maxsofar = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    subset[i]=Math.max(subset[i],subset[j]+1);
                }
            }
            maxsofar = Math.max(maxsofar,subset[i]);
        }
    return maxsofar;
    }
}
