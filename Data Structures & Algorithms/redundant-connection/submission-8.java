
class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int root1 = getParent(edge[0]);
            int root2 = getParent(edge[1]);

            if (root1 == root2) {
                return edge;
            }

            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
                rank[root2]++;
            }
        }

        return new int[0];
    }

    public int getParent(int node) {
        if (parent[node] != node) {
            parent[node] = getParent(parent[node]);
        }
        return parent[node];
    }
}
