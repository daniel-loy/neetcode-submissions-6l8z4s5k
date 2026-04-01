class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxsofar = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                maxsofar = Math.max(maxsofar, dynpro(i, j, dp, matrix));
            }
        }

        return maxsofar;
    }

    public int dynpro(int row, int col, int[][] dp, int[][] matrix){

        if(dp[row][col] != 0){
            return dp[row][col];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxvalue = 1;  // Path must include the current cell

        int[] rowoffset = {0, 1, 0, -1};
        int[] coloffset = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++){

            int newRow = row + rowoffset[i];
            int newCol = col + coloffset[i];

            // Correct boundary check
            if(newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols){
                continue;
            }

            // Must strictly increase
            if(matrix[newRow][newCol] <= matrix[row][col]){
                continue;
            }

            int result = dynpro(newRow, newCol, dp, matrix);
            maxvalue = Math.max(maxvalue, 1 + result);
        }

        dp[row][col] = maxvalue;
        return maxvalue;
    }
}
