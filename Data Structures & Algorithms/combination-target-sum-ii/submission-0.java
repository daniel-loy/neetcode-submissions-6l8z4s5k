class Solution {
        List<List<Integer>> arr = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        subsetsArray(candidates, new ArrayList<>(), target,0,0);
        return arr;
    }
        private void subsetsArray(int[] nums, List<Integer> list,int target,int sum,int index) {
        int usednumber = 0;
        if(sum==target){

            arr.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i]!=usednumber){
            list.add(nums[i]); 
            subsetsArray(nums, list, target,sum+nums[i],i+1);  
            usednumber=list.remove(list.size() - 1);     
            }
        }
    }
}
