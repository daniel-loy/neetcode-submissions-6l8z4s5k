class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(i,j,board,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int row,int col,char[][] board,String word,int index){
            System.out.println(index+" "+word.charAt(index)+" "+board[row][col]);
            if(word.charAt(index)!=board[row][col]){
                return false;
            }

            if(index+1 == word.length()){
                return true;
            }
            int[] rowoffset = {0,1,0,-1};
            int[] coloffset = {-1,0,1,0};
            char temp = board[row][col];
            board[row][col] = '#';

            for(int i=0;i<4;i++){
                int newrow = row+rowoffset[i];
                int newcol = col+coloffset[i];
                if(newrow<0 || newcol<0 || newrow>=board.length || newcol >= board[newrow].length || board[newrow][newcol] == '#'){
                    continue;
                }

                if(dfs(newrow,newcol,board,word,index+1)){
                    board[row][col] = temp;
                    return true;
                }
            }
            board[row][col] = temp;
            return false;
    }
    }

