class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Farthest -> closest
        Arrays.sort(indices, (i, j) -> Integer.compare(position[i], position[j]));

        int result = 0;
        double maxTime = 0;

        // Process closest -> farthest
        for (int i = n - 1; i >= 0; i--) {
            int idx = indices[i];

            double time = (double) (target - position[idx]) / speed[idx];

            if (time > maxTime) {
                result++;
                maxTime = time;
            }
        }

        return result;
    }
}
