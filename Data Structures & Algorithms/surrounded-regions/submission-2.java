class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    if(dfs(i,j,board)){
                        board[i][j]='X';        
                    }                }
            }
        }
    }

    public boolean dfs (int row, int col, char[][] board){

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        if(board[row][col] == 'X'){
            return true;
        }
        int [][] directions = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}};
        char temp = board[row][col];
        board[row][col]='X';        
        for(int[] dir: directions){

            int newRow = row+dir[0];
            int newCol = col+dir[1];
        
            if(!dfs(newRow, newCol, board)){
                board[row][col]='O';        
                return false;
            };
        }
        board[row][col]='O';        
        return true;
    }
}
