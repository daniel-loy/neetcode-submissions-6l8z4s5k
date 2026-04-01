class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
            int n = 0;

    for (int num : set) {
        n=num;
    }

    return n;
    }

}
