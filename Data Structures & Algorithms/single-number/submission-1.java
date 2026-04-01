class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int isrepeat = 1;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev != nums[i]){
                if(isrepeat == 1 ){
                    return prev;
                }
                else{
                    isrepeat=0;
                }
            }
            prev = nums[i];
            isrepeat+=1;
        }
        if(isrepeat == 1){
            return prev;
        }
        else{
            return 0;
        }
    }

}
