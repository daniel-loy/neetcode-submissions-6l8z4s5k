class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int[] overlappinginterval = intervals[0];
        int result = 0;
        for(int i=1;i<intervals.length;i++){
            if(overlappinginterval[1]>intervals[i][0]){
                result++;
                overlappinginterval[0] = Math.min(overlappinginterval[0],intervals[i][0]);
                overlappinginterval[1] = Math.min(overlappinginterval[1],intervals[i][1]);
            }
            else{
                overlappinginterval = intervals[i];
            }
        }

        return result;
    }
}
