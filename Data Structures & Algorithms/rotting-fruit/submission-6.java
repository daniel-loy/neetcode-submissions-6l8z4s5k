class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j,0});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int queuesize = queue.size();

        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};
        int count = 0;
        while(!queue.isEmpty()){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                count = cell[2];
                for(int j=0;j<4;j++){
                    int newrow = row+rowoffset[j];
                    int newcol = col+coloffset[j];
                    if(newrow<0 || newcol<0 || newrow>=grid.length || newcol >= grid[0].length || grid[newrow][newcol]==0 || grid[newrow][newcol]==2){
                        continue;
                    }
                    queue.offer(new int[]{newrow,newcol,count+1});
                    grid[newrow][newcol] = 2;
                    fresh--;
                }
            }


        if(fresh > 0){
            return -1;
        }

        return count;    }
}
