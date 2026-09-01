class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] grid = new HashSet[9];

        for(int i=0;i<9;i++){
            row[i]=new HashSet<Character>();
            col[i]=new HashSet<Character>();
            grid[i] = new HashSet<Character>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                int index = (i/3)*3+(j/3);
                char value = board[i][j];
                if(row[i].contains(value) || col[j].contains(value) || grid[index].contains(value)){
                    return false;
                }

                row[i].add(value);
                col[j].add(value);
                grid[index].add(value);
            }
            }
        }

        return true;

    }
}
