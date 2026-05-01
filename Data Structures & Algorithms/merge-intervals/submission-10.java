class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> list = new ArrayList<>();

        int[] currentinterval = intervals[0];

        for(int[] interval : intervals){
            if(currentinterval[0] <= interval[1] && currentinterval[1] >= interval[0]){
                    currentinterval[0]=Math.min(interval[0],currentinterval[0]);
                    currentinterval[1] = Math.max(interval[1],currentinterval[1]);
            }
            else{
                list.add(currentinterval);
                currentinterval = interval;
            }
        }

        list.add(currentinterval);

        int[][] result = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }
}
