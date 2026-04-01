
class Solution {
    List<List<Integer>> arr = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        subsetsArray(nums, new ArrayList<>(), 0);
        return arr;
    }

    private void subsetsArray(int[] nums, List<Integer> list, int index) {
        // Add the current subset (copy of list)
        arr.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);                // choose element
            subsetsArray(nums, list, i + 1);  // explore further
            list.remove(list.size() - 1);     // backtrack
        }
    }
}
