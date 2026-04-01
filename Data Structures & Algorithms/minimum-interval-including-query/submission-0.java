class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Integer[] arr = new Integer[queries.length];
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            arr[i]=i;
        }
        PriorityQueue<int[]> pri = new PriorityQueue<>((a,b)->Integer.compare(a[1]-a[0],b[1]-b[0]));
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Arrays.sort(arr,(a,b)->queries[a]-queries[b]);
        int n = intervals.length;
        int intvalstart = 0;
        for(int i=0;i<queries.length;i++){
            while(intvalstart<n && intervals[intvalstart][0]<=queries[arr[i]]){
                int left = intervals[intvalstart][0];
                int right = intervals[intvalstart][1];
                if(right>=queries[arr[i]]){
                pri.offer( intervals[intvalstart]);
                }
                intvalstart++;
            }

            while(!pri.isEmpty() && queries[arr[i]]>pri.peek()[0] && queries[arr[i]]>pri.peek()[1]){
                pri.poll();
            }

            if(pri.isEmpty()){
                result[arr[i]]=-1;
            }
            else{
                result[arr[i]]= pri.peek()[1]-pri.peek()[0] +1;
            }
        }

        return result;
    }
}
