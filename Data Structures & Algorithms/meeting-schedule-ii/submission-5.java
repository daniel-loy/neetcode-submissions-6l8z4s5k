/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> pri = new PriorityQueue<>((a,b)->a-b);
        Collections.sort(intervals,(a,b)->a.start-b.start);
        if(intervals.size()==0){
            return 0;
        }
        pri.offer(intervals.get(0).end);
        for(int i=1;i<intervals.size();i++){
            if(pri.peek()<=intervals.get(i).start){
                pri.poll();
                pri.offer(intervals.get(i).end);
            }
            else{
                pri.offer(intervals.get(i).end);
            }
        }
        return pri.size();
    }
}
