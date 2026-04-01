

class Solution {
    List<List<Integer>> arr = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsArray(nums,new ArrayList<>(),0);
        return arr;
    }
        private void subsetsArray(int[] nums, List<Integer> list,int index) {
        int previous=-50;
        arr.add(new ArrayList<>(list));
        
        if(list.size()==nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(previous!=nums[i]){
            list.add(nums[i]); 
            subsetsArray(nums, list,i+1);  
            previous=list.remove(list.size() - 1);    
            } 
        }
    }
}
