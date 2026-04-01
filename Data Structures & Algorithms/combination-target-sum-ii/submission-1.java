class Solution {
        List<List<Integer>> arr = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        subsetsArray(candidates, new ArrayList<>(), target,0,0);
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
                        if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]); 
            subsetsArray(nums, list, target,sum+nums[i],i+1);  
            list.remove(list.size() - 1);     
            
        }
    }
}
