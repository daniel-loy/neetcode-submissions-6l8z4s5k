class Solution {
    PriorityQueue<Integer> heap;
    public int findKthLargest(int[] nums, int k) {
        heap = new PriorityQueue<>(k);
        for(int num : nums){
            if(heap.size()<k){
                heap.offer(num);
            }
            else if(num>heap.peek()){
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();
    }
}
