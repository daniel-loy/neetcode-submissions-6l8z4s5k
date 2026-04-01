class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        int addedinterval = 0;
        for(int i=0;i<intervals.length;i++){
            if(((intervals[i][0]<=newInterval[0] && intervals[i][1]>=newInterval[0]) || (intervals[i][0]>=newInterval[0] && intervals[i][0] <=newInterval[1])) &&  addedinterval == 0){
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            }
            else if(intervals[i][0]>=newInterval[1] && intervals[i][1]>=newInterval[1] &&  addedinterval == 0){
                    list.add(Arrays.asList(newInterval[0],newInterval[1]));
                    list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                    addedinterval=1;
            }
            else{
                list.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }
            }
            if(addedinterval==0){
                                    list.add(Arrays.asList(newInterval[0],newInterval[1]));

            }

        int[][] arr = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                arr[i][j] = list.get(i).get(j);
        }
        }
        return arr;
        }
    }

