class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();
        int[] inDegree = new int[numCourses]; // in-degree of each course
        ArrayList<Integer> scheduler = new ArrayList<>();

        // Build graph and in-degree array
        for (int[] pre : prerequisites) {
            courseGraph.computeIfAbsent(pre[1], k -> new LinkedList<>()).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all courses with in-degree 0 to queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int course = queue.poll();
            scheduler.add(course);

            if (!courseGraph.containsKey(course)) continue;

            for (int next : courseGraph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        // If not all courses were visited, there is a cycle
        if (scheduler.size() < numCourses) return new int[0];

        return scheduler.stream().mapToInt(i -> i).toArray();
    }
}
