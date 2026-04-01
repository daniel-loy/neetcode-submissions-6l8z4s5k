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
                max = Math.max(dfs(i,j,matrix,dp),max);
                }
            }
        }

        
        return max;
    }

    public int dfs(int row,int col,int[][] matrix,int[][] dp){
        if(dp[row][col]>0){
            return dp[row][col];
        }
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
            dp[row][col]=Math.max(dp[row][col],dfs(newrow,newcol,matrix,dp));
        }
        matrix[row][col]=temp;
        return ++dp[row][col];
    }
}
