

class Solution {
    HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    int[] minTime;

    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build adjacency list
        for (int[] edge : times) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new Pair(edge[1], edge[2]));
        }

        // Step 2: Initialize minTime with "infinity"
        minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];

        // Step 3: DFS from start node k
        dfs(k, 0, visited);

        // Step 4: Find the maximum time among reachable nodes
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE)
                return -1; // some node not reachable
            max = Math.max(max, minTime[i]);
        }
        return max;
    }

    private void dfs(int node, int time, boolean[] visited) {
        if (time >= minTime[node]) return; // already found a shorter time
        minTime[node] = time;

        if (!map.containsKey(node)) return;

        visited[node] = true;
        for (Pair<Integer, Integer> edge : map.get(node)) {
            int next = edge.getKey();
            int weight = edge.getValue();
            dfs(next, time + weight, visited);
        }
        visited[node] = false;
    }
}
