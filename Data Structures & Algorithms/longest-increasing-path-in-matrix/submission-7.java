class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int incresingpath = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j]==0){
                    dfs(matrix,dp,i,j);
                }
                incresingpath = Math.max(incresingpath,dp[i][j]);
            }
        }
        return incresingpath;
    }

    public int dfs(int[][] matrix,int[][] dp,int row,int col){

            if(dp[row][col]>0){
                return dp[row][col];
            }
            int nowways = 1;
            int[] rowoffset = {-1,0,1,0};
            int[] coloffset = {0,1,0,-1};
            int temp = matrix[row][col];
            matrix[row][col] = -1;
            for(int i=0;i<4;i++){
                int newrow = row+rowoffset[i];
                int newcol = col+coloffset[i];

                if(newrow<0 || newcol<0 || newrow>=matrix.length || newcol>= matrix[0].length || matrix[newrow][newcol]==-1 || temp>=matrix[newrow][newcol]){
                        continue;
                }

                nowways = Math.max(dfs(matrix,dp,newrow,newcol)+1,nowways);
            }
            dp[row][col] = nowways;
            matrix[row][col] = temp;
            return nowways;
    }
}
