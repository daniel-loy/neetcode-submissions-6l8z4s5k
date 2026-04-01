class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        // Start DFS from every treasure
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int row, int col, int distance) {
        int m = grid.length;
        int n = grid[0].length;

        // Check boundaries and water
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == -1) return;

        // If this cell already has a shorter distance, stop
        if (grid[row][col] < distance) return;

        // Update the distance
        grid[row][col] = distance;

        // Explore 4 directions
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            dfs(grid, row + rowOffset[k], col + colOffset[k], distance + 1);
        }
    }
}
