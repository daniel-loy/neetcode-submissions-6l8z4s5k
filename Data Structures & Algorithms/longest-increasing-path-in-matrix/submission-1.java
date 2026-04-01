class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxsofar = -1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                    maxsofar = Math.max(maxsofar,dynpro(i,j,dp,matrix));
            }
        }
        return maxsofar;
    }

    public int dynpro(int row,int col,int[][] dp,int[][] matrix){

        if(dp[row][col] != 0 ){
            return dp[row][col];
        }

        int maxvalue = 1;
        int[] rowoffset = {0,1,0,-1};
        int[] coloffset = {-1,0,1,0};

        for(int i=0;i<4;i++){
            if(row+rowoffset[i]<0 || col+coloffset[i]<0 || row+rowoffset[i]>=dp.length || col+coloffset[i] >= dp[0].length || matrix[row+rowoffset[i]][col+coloffset[i]]<=matrix[row][col] ){
                continue;
            }

    
            int result = dynpro(row+rowoffset[i],col+coloffset[i],dp,matrix)+1;
            if(result>maxvalue){
                maxvalue=result;
            }

        }
        dp[row][col] = maxvalue;
        return maxvalue;
    }
}
