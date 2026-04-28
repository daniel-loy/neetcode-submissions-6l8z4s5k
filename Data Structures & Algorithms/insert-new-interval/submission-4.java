class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {

            // Case 1: current interval is completely before newInterval
            if (interval[1] < newInterval[0]) {
                list.add(interval);
            }
            // Case 2: current interval is completely after newInterval
            else if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval; // shift newInterval forward
            }
            // Case 3: overlapping intervals → merge
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // add the final merged interval
        list.add(newInterval);

        return list.toArray(new int[list.size()][]);
    }
}