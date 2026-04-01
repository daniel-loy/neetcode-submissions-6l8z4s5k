class Solution {
    int max = 0;
    int areaofland = 0;
    public int maxAreaOfIsland(int[][] grid) {
               int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        for(int i=0;i<row;i++ ){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid);
                    if(max<areaofland){
                        max=areaofland;
                    }
                    areaofland=0;
                }
            }
        }
        return max;
    }

        public void dfs(int row,int col,int[][] grid){
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        if(col<0 || row<0 || col>=grid[0].length || row>=grid.length || grid[row][col] == 0){

            return;
        }
        areaofland = areaofland+1;
        grid[row][col] = 0;

        for(int i=0;i<4;i++){
            dfs(row+rowoffset[i],col+coloffset[i],grid);
        }
    }
}
