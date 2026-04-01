class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(0, visited, adj);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            dfs(neighbor, visited, adj);
        }
    }
}
