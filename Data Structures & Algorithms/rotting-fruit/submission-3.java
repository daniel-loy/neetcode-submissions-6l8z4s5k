class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j,0});
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,1,0,-1};
        int max = 0;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], time = cell[2];

            for(int i=0;i<4;i++){
                int newRow = row + rowOffset[i];
                int newCol = col + colOffset[i];

                if(newRow<0 || newCol<0 || newRow>=grid.length || newCol>=grid[0].length) continue;
                if(grid[newRow][newCol] != 1) continue; // only rot fresh oranges

                grid[newRow][newCol] = 2;
                queue.offer(new int[]{newRow, newCol, time+1});
                max = Math.max(max, time+1);
                fresh--;
            }
        }

        return fresh == 0 ? max : -1;
    }
}
