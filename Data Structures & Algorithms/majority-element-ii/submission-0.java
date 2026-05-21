
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int limit = nums.length / 3;

        for(int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) == limit + 1) {
                ans.add(num);
            }
        }

        return ans;
    }
}