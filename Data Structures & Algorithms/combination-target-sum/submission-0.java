class Solution {
    List<List<Integer>> arr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        subsetsArray(nums, new ArrayList<>(), target,0,0);
        return arr;
    }

    private void subsetsArray(int[] nums, List<Integer> list,int target,int sum,int index) {
        if(sum==target){
            arr.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]); 
            subsetsArray(nums, list, target,sum+nums[i],i);  
            list.remove(list.size() - 1);     
        }
    }
}
