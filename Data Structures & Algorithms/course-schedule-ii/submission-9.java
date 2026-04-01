class Solution {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses) {
        isPossible = true;
        color = new HashMap<>();
        adjList = new HashMap<>();
        topologicalOrder = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        if (!isPossible) return; // stop if cycle detected

        color.put(node, GRAY);

        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GRAY) {
                // cycle detected
                isPossible = false;
            }
        }

        color.put(node, BLACK);
        topologicalOrder.add(node); // add after visiting neighbors (post-order)
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses);

        // Build adjacency list: prerequisite -> dependent courses
        for (int[] pre : prerequisites) {
            int preCourse = pre[1];
            int course = pre[0];
            adjList.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(course);
        }

        // Perform DFS for all nodes
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        if (!isPossible) return new int[0]; // cycle exists

        // Reverse post-order to get correct topological order
        Collections.reverse(topologicalOrder);

        return topologicalOrder.stream().mapToInt(i -> i).toArray();
    }
}