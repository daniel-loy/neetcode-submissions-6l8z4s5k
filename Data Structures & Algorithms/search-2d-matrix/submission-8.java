class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j = (matrix.length*matrix[0].length)-1;
        int rowcount = matrix.length;
        int colcount = matrix[0].length;
        while(i<=j){
            int mid = (i+j)/2;

            int row = mid / colcount;
            int col = mid - row*colcount;
            System.out.println(row+" "+col);
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){
                i = mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return false;
    }
}
