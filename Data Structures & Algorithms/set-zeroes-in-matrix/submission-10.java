class Solution {
    public void setZeroes(int[][] matrix) {

        boolean row =  matrix[0][0]==0;
        boolean col =  matrix[0][0]==0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i == 0){
                        row = true;
                    }
                    if(j==0){
                        col = true;
                    }
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=0;
                }
            }
        }

        if(col){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }     
        }

        
        if(row){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }     
        }
    }
}
