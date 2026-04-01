class Solution {
    int max = Integer.MIN_VALUE;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j]!=0){
                 max = Math.max(max,dp[i][j]);
                }
                else{
                max = Math.max(dfs(i,j,0,matrix,dp)+1,max);
                }
            }
        }

        
        return max;
    }

    public int dfs(int row,int col,int path,int[][] matrix,int[][] dp){
        // if(dp[row][col]>0){
        //     return dp[row][col]+1;
        // }
        int returnpath = path;
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};

        int temp = matrix[row][col];
        matrix[row][col]=-1;

        for(int i=0;i<4;i++){
            int newrow = row+rowoffset[i];
            int newcol = col+coloffset[i];

            if(newrow <0 || newcol <0 || newrow>=matrix.length || newcol>=matrix[0].length || matrix[newrow][newcol] == -1 || matrix[newrow][newcol] <= temp){
                continue;
            }
            int newpath = dfs(newrow,newcol,path+1,matrix,dp);
            returnpath = Math.max(newpath,returnpath);
            // if(newpath-path>dp[row][col]){
            //     dp[row][col]=newpath-path;
            //     max = Math.max(max,dp[row][col]);
            // }
        }
        matrix[row][col]=temp;

        return returnpath;
    }
}
