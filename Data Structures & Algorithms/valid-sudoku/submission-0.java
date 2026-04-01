class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N =9;
        HashSet<Character>[] row = new HashSet[N];
        HashSet<Character>[] col = new HashSet[N];
        HashSet<Character>[] box = new HashSet[N];

        for(int i=0;i<N;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            box[i]=new HashSet<>();
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
             if (board[i][j] == '.') {
                    continue;
                }
                if(row[i].contains(board[i][j])){
                    return false;
                }
                row[i].add(board[i][j]);

                if(col[j].contains(board[i][j])){
                    return false;
                }
                col[j].add(board[i][j]);

                int k = (i/3)*3+(j/3);

                if(box[k].contains(board[i][j])){
                    return false;
                }
                box[k].add(board[i][j]);
            }
        }
        return true;
    }
}
