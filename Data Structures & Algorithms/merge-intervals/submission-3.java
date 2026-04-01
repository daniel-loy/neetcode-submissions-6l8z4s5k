class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int[] newInterval = new int[2];
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        newInterval[0]=intervals[0][0];
        newInterval[1]=intervals[0][1];

        for(int i=1;i<n;i++){
            if(intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            else{
             result.add(new int[]{newInterval[0],newInterval[1]});
                newInterval[0]=intervals[i][0];
                newInterval[1]=intervals[i][1];
            }
        }

        result.add( new int[]{newInterval[0],newInterval[1]});
        // Convert list to int[][]
        return result.toArray(new int[result.size()][]);
    }
}
