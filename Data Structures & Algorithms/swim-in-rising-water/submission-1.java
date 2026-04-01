class Solution {
    int maxelevation = Integer.MAX_VALUE;

    public int swimInWater(int[][] grid) {
        int n = grid.length; 
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
        queue.add(Arrays.asList(0, 0, 0));

        int[] rowoffset = {-1, 0, 1, 0};
        int[] coloffset = {0, 1, 0, -1};
        int maxsofar = -1;
        boolean[][] visited = new boolean[n][n];

        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int row = list.get(0);  
            int col = list.get(1);  
            if (visited[row][col]) continue;
            visited[row][col] = true;

            maxsofar = Math.max(maxsofar, grid[row][col]);

            if (row == grid.length - 1 && col == grid.length - 1) {
                maxelevation = maxsofar;
                break;
            }
                System.out.println(grid[row][col]);

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowoffset[i];
                int newCol = col + coloffset[i];
                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid.length) {
                    continue;
                }

                if (!visited[newRow][newCol]) {
                    queue.add(Arrays.asList(newRow, newCol, grid[newRow][newCol]));
                }
            }
        }

        return maxelevation;
    }
}