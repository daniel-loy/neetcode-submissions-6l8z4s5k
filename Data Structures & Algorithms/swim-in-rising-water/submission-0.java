class Solution {
    int maxelevation = Integer.MAX_VALUE;
    public int swimInWater(int[][] grid) {
        dfs(grid,0,0,-1);
        return maxelevation;
    }

    public void dfs(int[][] grid,int row,int col,int maxsofar){

        maxsofar=Math.max(maxsofar,grid[row][col]);

        if(row==grid.length-1 && col==grid.length-1){
            maxelevation=maxsofar;
            return;
        }

        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};
        int temp=grid[row][col];
        grid[row][col]=-1;
        for(int i=0;i<4;i++){
            if(row+rowoffset[i]<0 || col+coloffset[i]<0 || row+rowoffset[i]>=grid.length || col+coloffset[i]>=grid.length || grid[row+rowoffset[i]][col+coloffset[i]] == -1){
            continue;
            }
            if(maxsofar<maxelevation){
               dfs(grid,row+rowoffset[i],col+coloffset[i],maxsofar);
            }
        }
        grid[row][col]=temp;
    }
}
