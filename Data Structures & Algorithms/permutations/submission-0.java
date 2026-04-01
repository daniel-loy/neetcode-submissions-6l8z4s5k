
class Solution {
    List<List<Integer>> arr = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Permutation(nums, new ArrayList<>(), 0);
        return arr;
    }

    private void Permutation(int[] nums, List<Integer> list, int index) {
        if (list.size() == nums.length) {
            arr.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue; // skip already-used numbers

            list.add(nums[i]);
            Permutation(nums, list, index + 1);
            list.remove(list.size() - 1); // backtrack
        }
    }
}
