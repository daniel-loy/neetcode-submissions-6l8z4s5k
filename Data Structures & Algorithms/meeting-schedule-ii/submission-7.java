
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        // Fill start and end arrays
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        // Sort both arrays
        Arrays.sort(start);
        Arrays.sort(end);

        int startPtr = 0;
        int endPtr = 0;
        int rooms = 0;
        int maxRooms = 0;

        while (startPtr < n) {
            
            if (start[startPtr] >= end[endPtr]) {
                // A meeting ended → free a room
                rooms--;
                endPtr++;
            }

            // New meeting starts → need a room
            rooms++;
            startPtr++;

            // Track maximum rooms used at any time
            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }
}