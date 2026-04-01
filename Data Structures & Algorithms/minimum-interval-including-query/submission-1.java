class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] arr = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<intervals.length;j++){
                 if(queries[i]>=intervals[j][0] && queries[i]<=intervals[j][1]){
                    int minlength = intervals[j][1]-intervals[j][0]+1;
                    if(minlength<min){
                        min = minlength;
                    }
                 }
            }
            arr[i]= min==Integer.MAX_VALUE?-1:min;
        }
        return arr;
    }
}
