class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];

        for (int[] interval : intervals) {
            if (current[1] < interval[0]) {
                list.add(current);
                current = interval;
            } else {
                current[1] = Math.max(current[1], interval[1]);
            }
        }

        list.add(current);

    int[][] result = new int[list.size()][2]; 

    for(int i=0;i<list.size();i++)
    { 
        result[i] = list.get(i); 
    }
    return result;
    }
}