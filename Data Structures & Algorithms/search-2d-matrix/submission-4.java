class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int right=(matrix[0].length*matrix.length)-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length]==target){
                return true;
            }
            else if(matrix[mid/matrix[0].length][mid%matrix[0].length]<target){
                left = ((left+right)/2)+1;
            }
            else{
                right=((left+right)/2)-1;
            }  
        }
        return false;
    }
}
