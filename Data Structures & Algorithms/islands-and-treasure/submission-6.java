class Solution {

    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: add all gates to queue
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        // Step 2: BFS
        while(!queue.isEmpty()){

            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int i=0;i<4;i++){

                int newrow = row + rowoffset[i];
                int newcol = col + coloffset[i];

                if(newrow<0 || newcol<0 || newrow>=rows || newcol>=cols){
                    continue;
                }

                if(grid[newrow][newcol] != 2147483647){
                    continue;
                }

                grid[newrow][newcol] = grid[row][col] + 1;

                queue.offer(new int[]{newrow,newcol});
            }
        }
    }
}
