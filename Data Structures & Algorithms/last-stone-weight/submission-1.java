class Solution {
    private PriorityQueue<Integer> heap;
    public int lastStoneWeight(int[] stones) {
        heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            heap.offer(stones[i]);
        }
        while(heap.size()>1){
            int first = heap.poll();
            int second = heap.poll();
            heap.offer(first-second);
        }

        return heap.peek();
    }
}
