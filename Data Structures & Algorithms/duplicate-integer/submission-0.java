class Solution {
    public boolean hasDuplicate(int[] nums) {
 HashSet<Integer> set = new HashSet<>();
        if(nums.length == 0 || nums.length == 1){
            return false;
        }
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }
            else{
                set.add(i);
            }
        }
        return false;
    
    }
}
