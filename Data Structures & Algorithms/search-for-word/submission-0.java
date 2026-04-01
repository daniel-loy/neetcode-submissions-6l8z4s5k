class Solution {

    public boolean exist(char[][] board, String word) {
        // Try starting the search from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Findword(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Findword(char[][] board, String word, int WordIndex, int row, int column) {
        // Out of bounds check
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length)
            return false;

        // Character mismatch check
        if (board[row][column] != word.charAt(WordIndex))
            return false;

        // Found the last character
        if (WordIndex == word.length() - 1)
            return true;

        // Mark as visited
        char temp = board[row][column];
        board[row][column] = '#';

        // Explore all 4 directions
        boolean found = 
            Findword(board, word, WordIndex + 1, row - 1, column) || // up
            Findword(board, word, WordIndex + 1, row + 1, column) || // down
            Findword(board, word, WordIndex + 1, row, column - 1) || // left
            Findword(board, word, WordIndex + 1, row, column + 1);   // right

        // Backtrack — restore original letter
        board[row][column] = temp;

        return found;
    }
}
