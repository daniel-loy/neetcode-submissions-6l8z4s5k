class Solution {
    int min = Integer.MAX_VALUE;
    public int swimInWater(int[][] grid) {
        dfs(0,0,Integer.MIN_VALUE,grid);
        return min;
    }

    public void dfs(int row,int col,int maxtime,int[][] grid){

        if(row == grid.length-1 && col == grid[0].length-1){
                maxtime = Math.max(maxtime,grid[row][col]);
                min = Math.min(min,maxtime);
                return;
        }
        
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};
        maxtime = Math.max(maxtime,grid[row][col]);

        if(maxtime>min){
            return;
        }
        int temp = grid[row][col];
        grid[row][col]=-1;
        for(int i=0;i<4;i++){
            int newrow = row+rowoffset[i];
            int newcol = col+coloffset[i];
            if(newrow<0 || newrow>=grid.length || newcol<0 || newcol>=grid[0].length || grid[newrow][newcol]==-1){
                continue;
            }
            
            dfs(newrow,newcol,maxtime,grid);
        }
        grid[row][col]=temp;
    }
}
