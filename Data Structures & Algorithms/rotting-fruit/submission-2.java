class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] rowoffer = {-1,0,1,0};

        int[] coloffer = {0,1,0,-1};
        int max = 0;
        while(!queue.isEmpty()){
            int[] rowcol = queue.poll();
            for(int i=0;i<4;i++){
                int row = rowcol[0]+rowoffer[i];
                int col = rowcol[1]+coloffer[i];
                if(row<0 || col<0 || row >= grid.length || col>= grid[0].length || grid[row][col]==2 || grid[row][col] == 0){
                    continue;
                }
                grid[row][col] = 2;
                queue.offer(new int[]{row,col,rowcol[2]+1});
                max=Math.max(max,rowcol[2]+1);
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return max;
    }
}
