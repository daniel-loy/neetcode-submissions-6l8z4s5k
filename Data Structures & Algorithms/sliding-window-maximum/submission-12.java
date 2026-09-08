class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));

        int[] result = new int[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            pq.add(i);
        }

        result[0] = nums[pq.peek()];

        // Remaining windows
        for (int i = k; i < nums.length; i++) {

            pq.add(i);

            // Remove indices outside the current window
            while (pq.peek() < i - k + 1) {
                pq.poll();
            }

            result[i - k + 1] = nums[pq.peek()];
        }

        return result;
    }
}