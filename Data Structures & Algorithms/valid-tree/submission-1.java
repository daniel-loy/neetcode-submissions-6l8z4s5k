class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // tree must have n-1 edges

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Undirected graph: add both ways
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        // DFS from node 0
        if (hasCycle(0, -1, visited)) return false;

        // Check if all nodes are visited (graph must be connected)
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean hasCycle(int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int nei : map.get(node)) {
            if (!visited[nei]) {
                if (hasCycle(nei, node, visited)) return true;
            } 
            else if (nei != parent) {
                // Cycle found
                return true;
            }
        }
        return false;
    }
}
