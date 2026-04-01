class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] arr = new int[queries.length];
        PriorityQueue<Integer> querieindex = new PriorityQueue<>((a,b)->Integer.compare(queries[a],queries[b]));
        for(int i=0;i<queries.length;i++){
            querieindex.offer(i);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pri = new PriorityQueue<>((a,b)->Integer.compare(a[1]-a[0]+1,b[1]-b[0]+1));
        int idx = 0;
        while(!querieindex.isEmpty()){
            int poped = querieindex.poll();

            while (idx < intervals.length && intervals[idx][0] <= queries[poped]) {
                pri.offer(intervals[idx]);
                idx++;
            }

            while(!pri.isEmpty() && queries[poped]>pri.peek()[1]){
                pri.poll();
            }
            if(!pri.isEmpty() && queries[poped]>=pri.peek()[0] && queries[poped]<=pri.peek()[1]){
            arr[poped]=pri.peek()[1]-pri.peek()[0]+1;

            }
            else{
               arr[poped]=-1; 
            }
        }
        return arr;

        }
    }

