class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            boolean[][] visited = new boolean[board.length][board[0].length];                
            if(board[i][j]!=word.charAt(0)){
                    continue;
                }
                if(dfs(board,word,"",i,j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,String word,String substring,int i,int j,boolean[][] visited){

String next = substring + board[i][j];

if (!word.startsWith(next)) {
    return false;
}
        if(word.equals(next)){
            return true;
        }

        int[] row = {0,-1,0,1};
        int[] col = {1,0,-1,0};

        for(int k=0;k<4;k++){
            int newrow = row[k]+i;
            int newcol = col[k]+j;

            if(newrow<0 || newcol<0 || newrow>board.length-1 || newcol>board[0].length-1 || visited[newrow][newcol] ){
                continue;
            }
            visited[i][j]=true;
            if(dfs(board,word,next,newrow,newcol,visited)){
                return true;
            }
            visited[i][j]=false;
        }
        return false;
    }
}
