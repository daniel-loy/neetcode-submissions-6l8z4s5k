class Solution {
    int min = Integer.MAX_VALUE;
    public int swimInWater(int[][] grid) {
        dfs(0,0,-1,grid);
        return min;
    }

    public void dfs(int row,int col,int mintime,int[][] grid){

        mintime = Math.max(mintime,grid[row][col]);
        if(row==grid.length-1 && col == grid[0].length-1){
            min = mintime;
            return;
        }

        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        int temp = grid[row][col];
        grid[row][col] = -1;
        for(int i=0;i<4;i++){
            int newrow = row+rowoffset[i];
            int newcol = col+coloffset[i];
            if(newrow<0 || newrow>=grid.length || newcol<0 || newcol>=grid[0].length || grid[newrow][newcol]==-1 ){
                continue;
            }
            if(mintime<min){
            dfs(newrow,newcol,mintime,grid);
            }
        }
        grid[row][col] = temp;
    }
}
