class Solution {
    int[] parent;

    public boolean validTree(int n, int[][] edges) {

        // Rule 1: Must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        parent = new int[n];

        // Initialize
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int root1 = find(edge[0]);
            int root2 = find(edge[1]);

            // If same root → cycle detected
            if (root1 == root2) return false;

            // Union
            parent[root2] = root1;
        }

        return true;
    }

    private int find(int x) {
        if (parent[x] == x) return x;

        // Path compression
        return parent[x] = find(parent[x]);
    }
}