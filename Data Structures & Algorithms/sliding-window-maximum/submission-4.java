class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        result[0] = maxHeap.peek();

        for (int i = k; i < nums.length; i++) {
            int toRemove = nums[i - k];
            freqMap.put(toRemove, freqMap.get(toRemove) - 1);
            maxHeap.add(nums[i]);
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            // Clean up top of heap (lazy deletion)
            while (freqMap.get(maxHeap.peek()) == 0) {
                maxHeap.poll();
            }

            result[i - k + 1] = maxHeap.peek();
        }

        return result;
    }
}
