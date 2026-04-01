class Solution {
    public int numIslands(char[][] grid) {
        int totalcount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                dfs(i,j,grid);
                totalcount++;
                }
            }
        }
        return totalcount;
    }

    public void dfs(int row,int col,char[][] grid){
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};
        grid[row][col]='0';
        for(int i=0;i<4;i++){
            int newrow = row+rowoffset[i];
            int newcol = col+coloffset[i];

            if(newrow<0 || newcol<0 || newrow>=grid.length || newcol>=grid[0].length || grid[newrow][newcol]=='0'){
                continue;
            }

            dfs(newrow,newcol,grid);
        }
    }
}
