class KthLargest {
    PriorityQueue<Integer> pri;
    int size;

    public KthLargest(int k, int[] nums) {
        pri = new PriorityQueue<>();
        size = k;

        for (int val : nums) {
            add(val);
        }
    }

    public int add(int val) {
        if (pri.size() == size) {
            if (val >= pri.peek()) {
                pri.poll();
                pri.add(val);
            }
        } else {
            pri.add(val);
        }
        return pri.peek(); // ✅ FIXED
    }
}
