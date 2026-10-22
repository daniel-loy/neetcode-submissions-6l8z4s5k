
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] status;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>())
               .add(p[1]);
        }

        status = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0 && findCycle(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean findCycle(int course) {
        if (status[course] == 1) {
            return true;
        }

        if (status[course] == 2) {
            return false;
        }

        status[course] = 1;

        for (int next : map.getOrDefault(course, new ArrayList<>())) {
            if (findCycle(next)) {
                return true;
            }
        }

        status[course] = 2;
        return false;
    }
}
