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
                    int area=dfs(i,j,grid);
                    max=Math.max(area,max);
                }
            }
        }
        return max;
    }

        public int dfs(int row,int col,int[][] grid){
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        if(col<0 || row<0 || col>=grid[0].length || row>=grid.length || grid[row][col] == 0){

            return 0;
        }
        areaofland = areaofland+1;
        grid[row][col] = 0;
        int area = 1; // Current cell

        for(int i=0;i<4;i++){
            area+=dfs(row+rowoffset[i],col+coloffset[i],grid);
        }

        return area;
    }
}
