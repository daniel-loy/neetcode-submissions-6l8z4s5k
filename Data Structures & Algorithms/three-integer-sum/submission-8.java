class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }

            int target = nums[i];

            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                if(nums[left]+nums[right]+target==0){
                    arr.add(new ArrayList<>(List.of(target,nums[left],nums[right])));
                    left++;
                    right--;
                                    while(left<right && nums[left]==nums[left-1]){
                    left++;
                }
                }
                else if(nums[left]+nums[right]+target > 0){
                    right--;
                }
                else{
                    left++;
                }


            }
        }

        return arr;
    }
}

