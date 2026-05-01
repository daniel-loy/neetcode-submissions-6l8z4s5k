class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int[] interval : intervals) {
            if (current[1] < interval[0]) {
                result.add(current);
                current = interval;
            } else {
                current[1] = Math.max(current[1], interval[1]);
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}