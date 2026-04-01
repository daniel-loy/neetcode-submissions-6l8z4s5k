class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int[] newInterval = new int[2];
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        newInterval=intervals[0];
        int count=0;
        for(int i=1;i<n;i++){
            if(intervals[i][0] >= newInterval[1]){
                count++;
                newInterval=intervals[i];
            }
        }

        // Convert list to int[][]
        return intervals.length-count-1;
    }
}
