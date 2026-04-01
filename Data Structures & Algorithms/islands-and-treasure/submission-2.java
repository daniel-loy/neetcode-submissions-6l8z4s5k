
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasures to the queue
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS from all treasures
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int k = 0; k < 4; k++) {
                int newRow = row + rowOffset[k];
                int newCol = col + colOffset[k];

                // Skip invalid cells or water
                if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;
                if(grid[newRow][newCol] != 2147483647) continue;

                // Update distance
                grid[newRow][newCol] = grid[row][col] + 1;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
