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
            int sub=Math.abs(first-second);
            System.out.println(sub);
            heap.offer(sub);
        }

        return heap.peek();
    }
}
