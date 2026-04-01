class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            dfs(i,0,board);
            dfs(i,col-1,board);
        }

        for(int i=0;i<col;i++){
            dfs(0,i,board);
            dfs(row-1,i,board);
        }

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='F'){
                    board[i][j]='O';
                }
            }
        }

    }
    public void dfs(int row,int col,char[][] grid){
        if(grid[row][col]=='X' || grid[row][col]=='F'){
            return;
        }
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};
        grid[row][col]='F';
        for(int i=0;i<4;i++){

            int newrow = row+rowoffset[i];
            int newcol = col+coloffset[i];

            if(newrow<0 || newcol<0 || newrow>=grid.length || newcol>=grid[0].length || grid[newrow][newcol]==0){
                continue;
            }

            dfs(newrow,newcol,grid);
        }
    }
}
