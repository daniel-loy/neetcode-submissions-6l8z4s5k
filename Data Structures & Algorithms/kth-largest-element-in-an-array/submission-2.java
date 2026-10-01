class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pri = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            pri.add(nums[i]);
            if(pri.size() > k){
                pri.poll();
            }
        }
        return pri.peek();
    }
}
